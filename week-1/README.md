# Week 1 - Arrays and strings

Solutions to all five problems in [the original assignment PDF](Assignment.pdf)
(`STEP=SEM-3 Week 1_Problems_Assignment.pdf`).
Each public static method uses the suggested assignment signature. Each class also
has a `main` method that reads standard input, so it can be run independently.
Java 8 or later is sufficient. No external libraries are needed.

## Compile and run

Open a terminal in `week-1`, then run:

```text
javac *.java
java ExamHallSeatDuplicationChecker
```

Enter the sample input for that program. Replace the class name to run a different
problem. Input contains values only, without braces, quotes, or labels. The
programs deliberately do not print input prompts, keeping the output consistent
with the assignment examples. Inputs must be non-null and follow the formats below.

## 1. Exam Hall Seat Duplication Checker

File: [ExamHallSeatDuplicationChecker.java](ExamHallSeatDuplicationChecker.java)

For each seat, first check whether the same value has already been processed.
If not, compare it with later seats. Print it when a matching seat is found.
This reports each duplicated value once, in first-occurrence order. Only arrays,
loops, and scalar variables are used for duplicate detection; no Collections,
sorting, or streams are used.

Input: the number of seats, followed by that many integers.

```text
5
101 102 103 102 105
```

Output:

```text
Duplicate Seat Number Found: 102
```

For `101 102 103 104 105`, the output is `No Duplicate Seats Found`.
An empty array also has no duplicates. Negative array sizes are rejected.
Time: O(n^2). Extra space in the checking method: O(1).

## 2. Typing Speed Test Accuracy Checker

File: [TypingSpeedAccuracyChecker.java](TypingSpeedAccuracyChecker.java)

Compare characters at each index using `charAt()`. Count matches and save the
first mismatch index. Accuracy is `matched * 100.0 / original.length()`;
floating-point arithmetic avoids integer truncation. Display positions starting
at 1, as in the PDF, and percentages with two decimal places.

Input: two complete lines of equal length. Spaces and case are significant.

```text
hello world
hello worlt
```

Output:

```text
Matched: 10/11 | Accuracy: 90.91% | First Mismatch at position 11 ('d' vs 't')
```

Two lines containing `coding` produce:

```text
Matched: 6/6 | Accuracy: 100.00% | No Mismatches
```

Unequal lengths are rejected. For two empty strings, this solution defines
accuracy as 100.00% with no mismatches, avoiding division by zero. Character
positions follow Java `charAt()` (UTF-16 code units), matching the assignment's
approach. Time: O(n). Extra space: O(1).

## 3. Traffic Signal Streak Analyzer

File: [TrafficSignalStreakAnalyzer.java](TrafficSignalStreakAnalyzer.java)

Keep the previous color and current streak length. Extend a streak for a repeated
color; otherwise restart at 1. Whenever the current length exceeds the best so
far, save its color and length. Equal-length ties keep the first streak.

Input:

```text
RRGGGYRR
```

Output:

```text
Longest Streak: 'G' repeated 3 times
```

`RRRRYYGG` produces `Longest Streak: 'R' repeated 4 times`.
An empty log prints `No Signal Readings Found`. Readings other than uppercase
`R`, `Y`, or `G` are rejected. Time: O(n). Extra space: O(1).

## 4. Warehouse Inventory Balancer

File: [WarehouseInventoryBalancer.java](WarehouseInventoryBalancer.java)

Sum each section and compare totals. During the same scans, track the maximum
quantity, its section, and index. Scan all of A before B and update only for a
strictly larger quantity: ties prefer Section A, then the earliest item in that
section, consistent with the sample. The displayed item number is the zero-based
array index plus 1. Totals use `long` to avoid overflow when adding `int` values.

Input: one shared item count, then all Section A quantities, then all Section B
quantities.

```text
3
20 15 30
25 10 30
```

Output:

```text
Section A Total: 65 | Section B Total: 65 | Status: Balanced | Highest Quantity: 30 (Section A, Item 3)
```

Unequal array lengths and negative input sizes are rejected. Empty arrays have
totals of 0, are balanced, and print `No Inventory Items Found` instead of a
maximum. The method supports all integer values; real stock quantities would
normally be nonnegative. Time: O(n). Extra space: O(1).

## 5. Movie Review Word Length Profiler

File: [MovieReviewWordLengthProfiler.java](MovieReviewWordLengthProfiler.java)

Split on whitespace using `split("\\s+")`. Count letters in each token, then
increment Short (1-4), Medium (5-8), or Long (9+) totals.

Input:

```text
This movie was absolutely fantastic and thrilling
```

Output:

```text
Short: 3 | Medium: 1 | Long: 3
```

Short: `This`, `was`, `and`. Medium: `movie`. Long: `absolutely`, `fantastic`,
`thrilling`.

The PDF does not specify punctuation behavior. This solution counts letters only
and ignores tokens containing no letters; punctuation therefore does not inflate
word length. Whitespace defines word boundaries, so a hyphenated or contracted
token is one word. Repeated whitespace and an empty review are supported.
Letter detection uses `Character.isLetter(char)`, suitable for English assignment
inputs; supplementary Unicode letters would require code-point traversal.
Time: O(n) in review length. Extra space: O(n) for the split words.

## Verification

Compile and run the included checks from `week-1`:

```text
javac *.java
java Week1Tests
```

The checks cover every PDF example, repeated duplicate values, empty inputs,
first mismatch positions, tied/final streaks, invalid input, inventory tie order,
large totals, and word-length boundaries. A failure throws `AssertionError`.
