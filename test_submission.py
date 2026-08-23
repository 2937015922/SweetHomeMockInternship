#!/usr/bin/env python3
"""Fast checks for required project files and submission evidence."""

from pathlib import Path
import sys


ROOT = Path(__file__).resolve().parent
SUBMISSIONS = ROOT / "submissions"


def evidence_for(task_name, extensions):
    if not SUBMISSIONS.is_dir():
        return []
    return [
        path for path in SUBMISSIONS.iterdir()
        if path.is_file()
        and task_name in path.name.lower()
        and path.suffix.lower() in extensions
    ]


def main():
    failures = []
    required_files = [
        ROOT / "pom.xml",
        ROOT / "SweetHome3D/src/com/eteks/sweethome3d/SweetHome3D.java",
        ROOT / "SweetHome3D/src/com/eteks/sweethome3d/model/HomePieceOfFurniture.java",
        ROOT / "SweetHome3D/src/com/eteks/sweethome3d/swing/PlanComponent.java",
    ]
    for path in required_files:
        if not path.is_file():
            failures.append(f"missing required file: {path.relative_to(ROOT)}")

    expected_evidence = {
        "task1": {".png", ".jpg", ".jpeg"},
        "task2": {".png", ".jpg", ".jpeg"},
        "task3": {".png", ".jpg", ".jpeg"},
        "task4": {".png", ".jpg", ".jpeg", ".pdf"},
    }
    for task_name, extensions in expected_evidence.items():
        if not evidence_for(task_name, extensions):
            failures.append(
                f"missing submissions/{task_name} evidence "
                f"({', '.join(sorted(extensions))})"
            )

    if failures:
        print("Submission structure: FAIL")
        for failure in failures:
            print(f"- {failure}")
        return 1

    print("Submission structure: PASS")
    print("Remember: screenshots/PDFs still require a brief manual review.")
    return 0


if __name__ == "__main__":
    sys.exit(main())
