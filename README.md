# Judicial Management System

A traditional Java web application designed to create, analyze, and manage judicial cases. This project leverages Java Server Pages (JSP) and Servlets to provide a web-based interface suitable for judicial case management.

## Features

- Create new judicial cases and store them in the system.
- Analyze existing cases with case details and history.
- Manage, update, and delete case records.
- User-friendly web interface built with JSP.
- Backend logic implemented using Java Servlets.

## Technologies Used

- Java (JDK 8+)
- Java Server Pages (JSP)
- Java Servlets
- Apache Tomcat v10.1
- MySQL
- HTML, CSS, JavaScript for frontend

## Getting Started

### Prerequisites

- Java JDK installed on your system.
- Apache Tomcat or similar Java EE server.
- MySQL server.

### Installation

1. **Clone the repository:**

   ```bash
   git clone https://github.com/Bhagy3sh/judicial-management-system.git
   ```

2. **Open in your IDE:**  
   Import the project as a Maven/Gradle/Java EE project in your preferred IDE (Eclipse/IntelliJ IDEA/NetBeans).

3. **Configure the server:**  
   Set up Apache Tomcat and configure the context path for the project.

4. **Database setup:**  
   The following schema outlines the MySQL database structure for the court management system. Each table is defined with its columns, primary key (underlined), and foreign key constraints.

---
- **Case**
  - Columns: caseNumber, filingDate, caseType, status, verdictId, categoryId, courtId
  - Primary Key: _caseNumber_
  - Foreign Keys:
    - FOREIGN KEY (verdictId) REFERENCES Verdict(verdictId)
    - FOREIGN KEY (categoryId) REFERENCES CaseCategory(categoryId)
    - FOREIGN KEY (courtId) REFERENCES Court(courtId)

- **Court**
  - Columns: courtId, courtName, location, jurisdictionLevel
  - Primary Key: _courtId_

- **Judge**
  - Columns: judgeId, name, designation, experienceYears, courtId
  - Primary Key: _judgeId_
  - Foreign Key: FOREIGN KEY (courtId) REFERENCES Court(courtId)

- **Lawyer**
  - Columns: lawyerId, name, contact, specialization, barRegistrationNumber, experienceYears
  - Primary Key: _lawyerId_

- **Person**
  - Columns: personId, name, dateOfBirth, contact, address, nationalId, petitioner, respondent, witness, policeOfficer
  - Primary Key: _personId_

- **Hearing**
  - Columns: hearingId, caseNumber, judgeId, date, time, description, outcome
  - Primary Key: _hearingId_
  - Foreign Keys:
    - FOREIGN KEY (caseNumber) REFERENCES Case(caseNumber)
    - FOREIGN KEY (judgeId) REFERENCES Judge(judgeId)

- **Verdict**
  - Columns: verdictId, caseNumber, date, decision, remarks, penalty
  - Primary Key: _verdictId_
  - Foreign Key: FOREIGN KEY (caseNumber) REFERENCES Case(caseNumber)

- **FIR**
  - Columns: firId, caseNumber, policeStationId, filedById, date, details, crimeLocation
  - Primary Key: _firId_
  - Foreign Keys:
    - FOREIGN KEY (caseNumber) REFERENCES Case(caseNumber)
    - FOREIGN KEY (policeStationId) REFERENCES PoliceStation(policeStationId)
    - FOREIGN KEY (filedById) REFERENCES Person(personId)

- **PoliceStation**
  - Columns: policeStationId, name, location, stationCode, contactNumber
  - Primary Key: _policeStationId_

- **Evidence**
  - Columns: evidenceId, caseNumber, type, description, collectedById, submissionDate
  - Primary Key: _evidenceId_
  - Foreign Keys:
    - FOREIGN KEY (caseNumber) REFERENCES Case(caseNumber)
    - FOREIGN KEY (collectedById) REFERENCES Person(personId)

- **Charges**
  - Columns: chargeId, caseNumber, legalActId, description, severityLevel, chargeDate
  - Primary Key: _chargeId_
  - Foreign Keys:
    - FOREIGN KEY (caseNumber) REFERENCES Case(caseNumber)
    - FOREIGN KEY (legalActId) REFERENCES LegalAct(legalActId)

- **LegalAct**
  - Columns: legalActId, actName, section, description, enactmentYear
  - Primary Key: _legalActId_

- **Bail**
  - Columns: bailId, caseNumber, personId, grantedDate, conditions, bailAmount, status
  - Primary Key: _bailId_
  - Foreign Keys:
    - FOREIGN KEY (caseNumber) REFERENCES Case(caseNumber)
    - FOREIGN KEY (personId) REFERENCES Person(personId)

- **CourtStaff**
  - Columns: staffId, name, role, contact, courtId
  - Primary Key: _staffId_
  - Foreign Key: FOREIGN KEY (courtId) REFERENCES Court(courtId)

- **Settlement**
  - Columns: settlementId, caseNumber, terms, date, agreementSigned
  - Primary Key: _settlementId_
  - Foreign Key: FOREIGN KEY (caseNumber) REFERENCES Case(caseNumber)

- **CaseHistory**
  - Columns: historyId, caseNumber, date, statusUpdate, notes, updatedById
  - Primary Key: _historyId_
  - Foreign Keys:
    - FOREIGN KEY (caseNumber) REFERENCES Case(caseNumber)
    - FOREIGN KEY (updatedById) REFERENCES Person(personId)

- **CourtRoom**
  - Columns: courtRoomId, courtId, roomNumber, capacity, availabilityStatus
  - Primary Key: _courtRoomId_
  - Foreign Key: FOREIGN KEY (courtId) REFERENCES Court(courtId)

- **CaseCategory**
  - Columns: categoryId, name, description
  - Primary Key: _categoryId_

- **Appeal**
  - Columns: appealId, caseNumber, filedById, date, reason, status, appealLevel
  - Primary Key: _appealId_
  - Foreign Keys:
    - FOREIGN KEY (caseNumber) REFERENCES Case(caseNumber)
    - FOREIGN KEY (filedById) REFERENCES Person(personId)
---

5. **Build and deploy:**  
   Build the project and deploy the `.war` file to your servlet container.

### Running the Application

- Access the application from your browser at `http://localhost:8080/judicial-management-system` (URL may vary based on your configuration).

## Usage

- **Create Case:** Navigate to the 'Create Case' section to add new cases.
- **View Cases:** Browse all cases, search, and filter them.
- **Edit/Delete:** Update or remove case information as needed.

## Contributing

1. Fork the repository.
2. Create a new branch (`git checkout -b feature/your-feature`).
3. Commit your changes (`git commit -am 'Add new feature'`).
4. Push to the branch (`git push origin feature/your-feature`).
5. Create a new Pull Request.

## License

This project is licensed under the MIT License.

## Acknowledgements

- Built with Java EE technologies.
- Thanks to contributors and the open-source community.

---

*Please update the database information, and add any specific instructions or features unique to your implementation for completeness.*
