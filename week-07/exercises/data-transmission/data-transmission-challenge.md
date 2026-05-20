# Data Transmission Challenge

## Rules
1. Students will be divided into teams of 5
2. Each team will process the same set of 20 number cards
3. Each student will be assigned a specific role with a role card
4. Teams will complete two different data processing methods
5. The goal is to correctly filter, transform, and sum the data

## Part 1: Traditional Data Processing

### Roles
1. **Source**: Holds all number cards
2. **Application**: Processes all cards using three operations
3. **Timer**: Records when processing is complete
4. **Observers**: Watch and verify the process

### Process
1. Source gives cards ONE AT A TIME to Application
2. Application performs all operations on each card
3. Application announces final sum when all cards processed
4. Timer records when the final sum is announced

### Part 1 Example:
- Source hands card "12" to Application
- Application processes the card (applies all operations)
- Application continues with running calculation
- Source hands next card "5" to Application
- Process continues until all cards are processed
- Application announces final result

---

## Part 2: Stream Pipeline

### Roles
1. **Source**: Holds all number cards
2. **Filter**: Checks if numbers meet criteria
3. **Mapper**: Transforms values
4. **Reducer**: Maintains running sum
5. **Timer**: Records when processing is complete

### Process
1. Students form a line in role order
2. Source passes cards one at a time to Filter
3. Filter immediately:
   1. Passes qualifying numbers to Mapper
   2. Discards non-qualifying numbers
3. Mapper transforms each received number and passes to Reducer
4. Reducer adds each number to running sum
5. When all cards processed, Reducer announces final sum
6. Timer records when the final sum is announced

## Starting Setup
1. Each team receives 20 number cards (1-20)
2. Students receive role cards explaining their specific job
3. Everyone begins in their designated position
4. Teams may not start until instructed

### Part 2 Example:
- Source passes card "7" to Filter
- Filter evaluates card and passes or discards based on criteria
- If passed, Mapper receives card and transforms value
- Reducer receives transformed value and updates sum
- Process continues with all cards flowing through pipeline