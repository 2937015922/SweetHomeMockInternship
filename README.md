# Sweet Home 3D mock internship

This repository is a small maintenance exercise based on the [Sweet Home 3D](https://sourceforge.net/projects/sweethome3d/)
5.4 desktop application. You are joining an established codebase: first get it
running, then make three user-facing improvements to furniture editing, the
furniture table, and printing.

Fork this repository on GitHub, then clone *your fork* and work there.
Do not clone the course repository directly or push to it.

Start with [QUICK_START.md](QUICK_START.md). The complete requirements,
reference screenshots, hints, and submission checklist are in
[ASSIGNMENT.md](ASSIGNMENT.md).

## Internship workflow

Treat Tasks 2–4 as small maintenance tickets: understand the request, make a
focused change, verify it, and commit the result. GitHub does not copy issues
from an upstream repository into a fork, so you may enable Issues in your fork
by opening **[Settings](../../settings)**, finding **Features**, and selecting
**Issues**. Then create one issue for each feature using the included
**[Internship task](../../issues/new?template=internship-task.md)** template.
Close each issue when its tests and acceptance evidence are complete.

Using GitHub Issues is recommended.

## Repository map

- `SweetHome3D/src` — Java application source and resources
- `assignment-tests` — public, headless acceptance tests
- `images` — reference before/after images
- `samples` — the multi-level home used for the printing task
- `pom.xml` — supported Maven build

This exercise is based on the
[Sweet Home 3D project](https://sourceforge.net/projects/sweethome3d/). The
original license and third-party notices remain under `SweetHome3D`.
