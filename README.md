## Group 6 "Gratitude Gangstaz" Backend Project: ⭐️ Gratitude Journal
## Documentation:

### About:
*An application whose main function is to allow a user to record daily notes of gratitude and a rating of their mood*

* *Mehlia Rahman*
* *Billie Redwood*
* *Rashad Ramali*
* *Joseph Carpentieri*
* *Thomas McLaughlin*


## The Project's aims
### For Users:

* Implements habits of *reflection* and *appreciation* into a users daily routine.
* Prompt users to *engage* with their mood and mental health in a *positive* way.
* Identify possible trends in a users lifestyle so feedback can be customised and tailored for each specific use case. 

### For Developers:
* Create code that is clearly written and well formatted to make it easy to work and extend upon. 
* Code-base available on an open source basis to allow for easier development within wellbeing software space. 


### The names and versions of any libraries used
* Spring Boot Starter Data JPA
* Spring Boot Starter Web
* Spring Boot devtools
* [Spring Boot Starter Mail](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-mail) 
* Postgresql


### Step-by-step setup instructions

1. Clone from github repo: `git@github.com:mclaughlin111/BNTA_BackendProject_GratitudeJournal.git`
2. Open up `GratitudeJournal`folder in intellij (or IDE of choice).
3. Check dependencies for spring dependencies specified above in pom.xml - if not installed it will not run correctly.
4. Create a postgreql database called gratitude_journal in terminal.
5. Run GratitudeJournal.java application.
6. Test mapping routes in API server of choice ([Click here](https://github.com/mclaughlin111/BNTA_BackendProject_GratitudeJournal/blob/main/GratitudeJournal.json) to download our pre-mapped Postman Collection to test routes). 



## MVP - Gratitude Journal

* Add a Journal Entry: 
	* Select day of the week ✅
	* Input mood rating	for the day ✅
	* Enter a gratitude entry in the journal ✅

* Display all Journal Entries ✅
* Update Journal Entry ✅
* Delete Journal Entry ✅


## Extension I - User
* Create a User ✅
* Update User Credentials ✅
* Delete User ✅

## Extension II - Filtering

* Filter Journal Entries by `Weekday` ✅
* Filter Journal Entries by `userId` ✅
* Filter Journal Entries by `moodRating`

## Extension III - up-to-5 Journal Entries

* Upon 5 Journal Entries for a single day, allow no additional entries ✅
* When 5 entries have been inputted on a single day, show status of Journal as `COMPLETE`.
* Write a method that calculates a weekly average from a users `MoodRating` and returns a score.

## Extension IV - Reward Streaks & User Incentive
* Create a database of motiviational quotes
* Write a method that returns a motivational quote to a user on a random basis
	* Send Email message directly to a users email address✅
	* extend method to only send motivational quotes to users below a certain MoodRating or below a specific `JournalEntry` average 
* Create a 'Streak' system that rewards users for continued daily usage at certain milestones (i.e. 3 days, 1 week, 1 month) with a virtual ⭐️ point system.


-

**Gratitude Journal**
**Class** Diagram
![ClassDiagram](https://github.com/mclaughlin111/BNTA_BackendProject_GratitudeJournal/assets/47330113/e12a3ed9-67cb-4444-bb55-e81320860e70)

**Entity Relationship** Diagram
![ERD_Diagram](https://github.com/mclaughlin111/BNTA_BackendProject_GratitudeJournal/assets/47330113/c7c5e2df-315e-4325-a127-0cc33de2c833)



## RESTful Routes: JournalEntry

###  Example Mappings:
#### Users

GET `localhost:8080/Users`

*JSON RESPONSE*


    {
        "id": 1,
        "name": "Billie",
        "emailAddress": "billie@bnta.com"
    },
    {
        "id": 2,
        "name": "Tom",
        "emailAddress": "toma@bnta.com"
    },
    {
        "id": 3,
        "name": "Mehlia",
        "emailAddress": "mehlia@bnta.com"
    },
    {
        "id": 4,
        "name": "Joe",
        "emailAddress": "joe@bnta.com"
    }

	

GET `localhost:8080/Users/id`

    {
        "id": 1,
        "name": "Billie",
        "emailAddress": "billie@bnta.com"
    }


POST `localhost:8080/Users` RequestBody: `User`

	{ 
		"name" : "username", 
		"emailAddress" : "emailaddress" 
	}
  
PATCH `localhost:8080/Users/id` RequestBody: `UserDTO`

	{ 
		"name" : "updated_username", 
		"emailAddress" : "updated_emailaddress"
	}

DELETE `localhost:8080/Users/id`

#### JournalEntries

GET `localhost:8080/journal-entries`


    {
        "id": 1,
        "content": "I had a great day today",
        "weekDay": "FRIDAY",
        "moodRating": "REALLYGOOD"
    },
    {
        "id": 2,
        "content": "I had bad day",
        "weekDay": "TUESDAY",
        "moodRating": "REALLYBAD"
    },
    {
        "id": 3,
        "content": "I had a good day",
        "weekDay": "THURSDAY",
        "moodRating": "POSITIVE"
    },
    {
        "id": 4,
        "content": "I had an average day",
        "weekDay": "SUNDAY",
        "moodRating": "INDIFFERENT"
    },
    {
        "id": 5,
        "content": "I had a mediocre day",
        "weekDay": "MONDAY",
        "moodRating": "NEGATIVE"
    },
    {
        "id": 6,
        "content": "I had a brilliant",
        "weekDay": "FRIDAY",
        "moodRating": "REALLYGOOD"
    }


GET `localhost:8080/journal-entries/id`
	
	{
	    "id": 1,
	    "content": "I had a great day today",
	    "weekDay": "FRIDAY",
	    "moodRating": "REALLYGOOD"
	}

POST `localhost:8080/journal-entries/id` RequestBody: `JournalEntry`
	

PATCH `localhost:8080/journal-entries/id` RequestBody: `EntryDTO`

	{
		“content”: “I had a beaut day”,
		“weekDay”: “WEDNESDAY”,
		“moodRating”: “POSITIVE”
	 }

DELETE `localhost:8080/journal-entries/id`



### GET Mapping

* Display all journal entries - `"/journal-entries"`

* Include optional path variable to display by journal entry ID - `"/{id}"`
* Response entity returns a List of all journal entries back to the user, or specific journal by ID.
* Return `HTTPStatus.OK`


### POST Mapping

* Include request body. Use a EntryDTO to get the UserId- 
	* `"userId" = 1,`
	* `"content" = "I am grateful.",`
	* `"weekDay" = "Monday",`
	* `"moodRating = "Great"`
* Response entity returns the posted journal entry back to the user
* Return `HTTPStatus.CREATED`

	
### PATCH Mapping

* Include path variables to select JournalEntry ID that we want to update - `"/{id}`
* Include request body of a journalEntry object to input information to be updated.
* Response entity returns the updated journal entry back to the user.
* Return `HTTPStatus.OK`


### DELETE Mapping

* Include path variable to select JournalEntry ID that we want to delete - `"/{id}`.
* Response entity returns JournalEntry ID that we deleted.
* Return `HTTPStatus.OK`

-
![group 6](https://github.com/mclaughlin111/BNTA_BackendProject_GratitudeJournal/assets/47330113/5b4ed22c-a2aa-4d2f-b4c7-1bfa114038bb)

