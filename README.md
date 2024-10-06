# Getting Started

Write a microservice application, that implements a ‘CRUD’
with REST endpoints for JSON entity (not for all entities, only for root entity)
with the structure :
The root object is the company.
Each company has name and departments.
Each department has name and contains teams.
Each team has name and project.
Each project has a manager with contact information.
Using:
Java 21, Spring, Postgres, Maven, GIT (local repository), Docker (just to start app)
and any other technologies (for some converting for example)
Note: keep it simple and clear, fulfilling the minimum requirements

Added one integration test with post and get method for company :) and one quick service unit test 
tables could be more optimised but i used just jpa functionality to make it fast and simple :) 

basic example for post:
POST http://localhost:8080/api/companies
Content-Type: application/json

{
  "name": "Tech Corp",
  "departments": [
    {
      "name": "IT Department",
      "teams": [
        {
          "name": "Development Team",
          "project": {
            "name": "NextGen Project",
            "manager": {
              "name": "Alice Johnson",
              "contactInfo": "alice.johnson@techcorp.com"
            }
          }
        },
        {
          "name": "QA Team",
          "project": {
            "name": "Quality Assurance Project",
            "manager": {
              "name": "Bob Smith",
              "contactInfo": "bob.smith@techcorp.com"
            }
          }
        }
      ]
    },
    {
      "name": "HR Department",
      "teams": [
        {
          "name": "Recruitment Team",
          "project": {
            "name": "Talent Acquisition Project",
            "manager": {
              "name": "Carol White",
              "contactInfo": "carol.white@techcorp.com"
            }
          }
        }
      ]
    }
  ]
}