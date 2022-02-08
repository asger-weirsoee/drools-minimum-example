# Example

When you write an Excel sheet with a date, let’s say the 1st January 2022, it’ll automatically mark that cell as a date.

When Drools picks up the xlsx sheet and converts it to .drl, it’ll format that date as 1/1/22.

Though 1/1/22 is not a date, it’s a division piece.

So when we compare a new date, let’s say the date;
01-01-2021 with it, an exception is raised as (the result of 1/1/22) 0. 045454545456 does not contain a timestamp.


Thus the following exception is raised

`java.lang.RuntimeException: Cannot extract timestamp from 0.045454545454545456`


