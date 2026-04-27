# Knack

A kanban companion for the user's job search. Single-user, browser-based, locally persisted. The domain is small but precise — terms here are load-bearing across UI, schema, and storage.

## Language

**Job**:
A single opportunity the user is tracking, from "interesting posting I saw" through to "got the offer / got rejected / never heard back."
_Avoid_: application, posting, role, position, opportunity, task.

**Status**:
The stage a **Job** is in. The MVP set is `:interested`, `:applying`, `:applied`, `:interview`, `:offer`, `:rejected`, `:ghosted`. The user can customise the set post-MVP.
_Avoid_: stage, state, phase, column.

**Board**:
The kanban view that groups all non-**Trashed** **Jobs** into columns by **Status**. The MVP has exactly one **Board**.
_Avoid_: kanban, view, dashboard.

**Comment**:
A timestamped, user-authored entry attached to a **Job** — for example, "phoned recruiter, said they'll get back next week." Append-only in the MVP. The comment list replaces the more usual free-text "notes" field because activity on a **Job** is inherently chronological.
_Avoid_: note, log entry, message.

**History event**:
An auto-generated, immutable record of a state change on a **Job** — for example, "status moved from `:applied` to `:interview` at 2026-04-29T10:14:00Z." Distinct from **Comment**: the user does not author or edit **History events**. Post-MVP feature.
_Avoid_: audit log, activity, change record.

**Tag**:
A user-applied label categorising the *effort* a **Job** represents. The canonical set is `:spray-and-pray`, `:light-touch`, `:deep-tailor`. Post-MVP.
_Avoid_: category, label, type, kind.

**Trash**:
The collection of soft-deleted **Jobs**. **Trashed Jobs** are excluded from the **Board** but recoverable until permanently purged. Post-MVP.
_Avoid_: archive, bin, deleted.

**Demo mode**:
A first-run path where the app loads a pre-seeded set of **Jobs** so a portfolio visitor can explore the **Board** without entering data. Distinct from a fresh start. Post-MVP.
_Avoid_: sample, fixtures, example data.

## Relationships

- A **Job** has exactly one **Status**.
- A **Job** has zero or more **Comments**, ordered by timestamp.
- A **Job** has zero or more **History events**, ordered by timestamp.
- A **Job** has zero or more **Tags**.
- A **Board** groups all non-**Trashed Jobs** by **Status**.
- A **History event** belongs to exactly one **Job**.
- A **Comment** belongs to exactly one **Job**.

## Example dialogue

> **Dev:** "When the user drags a card from `:applied` to `:interview`, do we add a **Comment** or a **History event**?"
> **Domain expert:** "**History event** — the user didn't write anything, the move is what we're recording. **Comments** are only ever things the user typed."
>
> **Dev:** "And if they want to record 'had a great call with the hiring manager'?"
> **Domain expert:** "That's a **Comment**. Same **Job**, different concept. The two lists render together in the modal as a unified timeline, but they live in separate fields and have different invariants."

## Flagged ambiguities

- **"notes" rejected in favour of Comment.** Early discussion used "personal notes" as a single free-text field on a **Job**. Resolved: replaced by a list of **Comments**, because real usage is inherently chronological and a free-text field would have to be parsed into events later. The data shape lands as a list from MVP day 1; the MVP UI is intentionally minimal (chronological list + single "add comment" input).
- **"log" / "activity" / "audit".** All three were used loosely. Resolved: **History event** for the auto-generated kind, **Comment** for the user-authored kind. They are not unified in the data model.
- **"column" vs. "Status".** "Column" describes a UI concept on the **Board**; the underlying domain concept is **Status**. A **Job** has a **Status**, not a column. Columns are a rendering of **Statuses**.
