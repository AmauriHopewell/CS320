This repository contains code and documentation from various software engineering projects, including back-end services in Java (Contact, Task, Appointment) with unit tests.
Below, I reflect on key aspects of the work to cement learning and provide context for future reference. 
To ensure functionality, I rely on comprehensive unit testing using frameworks like JUnit, as demonstrated in the Java services projects where I achieved over 80% code coverage by testing valid cases, edge cases (e.g., null inputs, length violations), and exceptions (e.g., assertThrows for invalid IDs in ContactTest.java). 
This catches errors early and verifies requirements like unique IDs and future dates in appointments. 
For security, I incorporate input validation in constructors and setters (e.g., regex for phone numbers in Contact.java to prevent malformed data) and use immutable fields where possible (e.g., final IDs) to avoid unauthorized updates. 
In practice, I'd extend this with integration tests, code reviews, and tools like OWASP ZAP for vulnerability scanning, while following principles like least privilege and secure coding standards to mitigate risks such as injection attacks.

I incorporate user needs by mapping needs to features—e.g., in the Java services, requirements like "add with unique ID" translated to HashMap-based storage with duplicate checks in add methods. 

My software design approach is iterative and requirement-driven, beginning with understanding constraints and breaking down into components as in the Java projects, 
where I designed classes (e.g., Contact with private validators) before services (e.g., ContactService with CRUD operations). 
I favor modular, object-oriented principles for reusability, using in-memory structures for simplicity in these prototypes. R
eflections on techniques (e.g., unit vs. integration testing) inform trade-offs, always prioritizing quality to avoid technical debt through
TDD.
