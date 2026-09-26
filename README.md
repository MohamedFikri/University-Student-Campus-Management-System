# University Student Record and Campus Route Management System

## Project Information

- **Module:** CIT300 – Data Structures and Algorithms
- **Assessment:** Graded Practical Assignment 1
- **Application Type:** Java Console Application
- **Project Title:** University Student Record and Campus Route Management System

## Project Overview

This Java console application manages university student records and campus routes. It demonstrates the practical use of linked lists, stacks, queues, binary search trees, hashing, and graphs.

The system allows users to manage student information, process student service requests, record recent actions, search student records efficiently, and manage connections between university campus locations.

## Main Features

- Add, update, delete, search, and display student records
- Store student records using a linked list
- Maintain recent actions using a custom stack
- Process student service requests using a custom queue
- Organize student records using a Binary Search Tree
- Search student records efficiently using hashing
- Represent campus locations using a graph
- Add and remove campus locations
- Add and remove campus roads
- Display campus connections
- Traverse campus locations using Breadth-First Search
- Validate incorrect and empty inputs
- Handle duplicate student IDs and locations
- Handle missing records and unavailable roads
- Validate student marks between 0 and 100

## Data Structures Used

| Data Structure | Purpose |
|---|---|
| Linked List | Store and manage student records |
| Stack | Maintain recent system actions using LIFO order |
| Queue | Process student service requests using FIFO order |
| Binary Search Tree | Organize student records by Student ID |
| Hash Table | Support efficient Student ID searching |
| Graph | Represent campus locations and road connections |
| BFS | Traverse connected campus locations |

## Group Members and Contributions

| Member Name | Student ID | Assigned Responsibility | Individual Contribution |
|---|---|---|---|
| Ammar | 23DA2-0990 | Linked List and Student Records | Implemented the Student class and linked-list operations for adding, updating, deleting, searching, and displaying student records. |
| Asheem | 23DA2-1089 | Stack and Queue | Implemented the custom action stack, service-request queue, FIFO processing, and related classes. |
| Fikri | 23DA2-0681 | Team Leader, BST, Hashing, and Integration | Implemented the Binary Search Tree, hash table, final menu integration, input validation, testing, debugging, and GitHub coordination. |
| M.N. Nuzail Ahamed | 23DA2-1022 | Graph and BFS | Implemented the campus graph using an adjacency list, location and road operations, campus connection display, and BFS traversal. |

## Shared Group Contribution

All group members participated in:

- Project planning and requirement analysis
- Integration of all data structures
- Input validation
- Functional testing and debugging
- GitHub branches, commits, and pull requests
- Project documentation
- Demonstration video preparation

## Menu Options

1. Add Student Record
2. Update Student Record
3. Delete Student Record
4. Display All Records using Linked List
5. Add Service Request to Queue
6. Process Next Service Request
7. Display Recent Actions using Stack
8. Display Students using BST
9. Search Student using Hashing
10. Add Campus Location
11. Remove Campus Location
12. Add Campus Connection/Road
13. Remove Campus Connection/Road
14. Display Campus Connections
15. Traverse Campus Locations using BFS
16. Exit

## Project Structure

- `Student.java` – Student data model
- `StudentLinkedList.java` – Linked-list student management
- `ActionStack.java` – Custom LIFO action stack
- `ServiceRequest.java` – Service-request data model
- `ServiceQueue.java` – Custom FIFO service queue
- `StudentBST.java` – Binary Search Tree implementation
- `StudentHashTable.java` – Hash-table implementation
- `CampusGraph.java` – Campus graph and BFS implementation
- `Main.java` – Menu and system integration

## Software Requirements

- Java Development Kit 17 or later
- Visual Studio Code or Apache NetBeans
- Git and GitHub

## Compile and Run

Open the terminal inside the project folder.

### Compile

`javac -d build src\universitymanagement\*.java`

### Run

`java -cp build universitymanagement.Main`

## Input Validation

The system handles:

- Invalid menu choices
- Empty user inputs
- Invalid marks
- Duplicate student IDs
- Duplicate campus locations
- Missing student records
- Missing campus locations
- Duplicate roads
- Unavailable roads
- Empty queues and stacks

## GitHub Collaboration

The project was developed collaboratively using separate Git branches, commits, and pull requests.

Main development branches:

- `ammar-linked-list`
- `asheem-stack-queue`
- `fikri-bst-hashing`
- `nuzail-graph`
- `fikri-final-integration`

## Conclusion

This project demonstrates how fundamental data structures and algorithms can be integrated into a practical Java console application for managing student records, service requests, and university campus routes.