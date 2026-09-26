# Sweet Home 3D mock internship

Welcome to your mock internship! You'll be working on the [Sweet Home 3D](https://sourceforge.net/projects/sweethome3d/)
5.4 desktop application. Like many software development internships, you'll be
joining an established codebase rather than starting a project from scratch.

Your first task is to get the application running. You'll then make three
user-facing improvements involving furniture editing, the furniture table,
and printing.

Before you begin, **fork this repository** on GitHub, then clone *your fork* and
work there. Do not clone the course repository directly or push to it.

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

Using GitHub Issues is **required**; once available, tests on MarkUs will check to verify
that your repo contains at least 3 closed issues.

## Repository map

- `SweetHome3D/src` — Java application source and resources
- `assignment-tests` — public, headless acceptance tests
- `images` — reference before/after images
- `samples` — the multi-level home used for the printing task
- `pom.xml` — supported Maven build

This exercise is based on the
[Sweet Home 3D project](https://sourceforge.net/projects/sweethome3d/). The
original license and third-party notices remain under `SweetHome3D`.

## Project scale

In case you are curious about the size of the project this is, below is the summary
produced by running [cloc](https://github.com/aldanial/cloc) on the repo:

```text
    1787 text files.
     914 unique files.                                          
    4070 files ignored.

github.com/AlDanial/cloc v 1.98  T=1.53 s (597.0 files/s, 158843.3 lines/s)
-------------------------------------------------------------------------------
Language                     files          blank        comment           code
-------------------------------------------------------------------------------
Java                           221           9302          27212          94306
HTML                           486           1154            133          57447
Properties                     189           9459           5968          37285
Markdown                         4             80              0            235
CSS                              2             32              0            210
Maven                            1              4              6            127
XML                              9              0              0             91
YAML                             1              6              0             55
Python                           1             12              1             47
-------------------------------------------------------------------------------
SUM:                           914          20049          33320         189803
-------------------------------------------------------------------------------
```
