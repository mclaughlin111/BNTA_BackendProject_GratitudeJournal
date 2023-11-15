## Group 6 "Gratitude Gangstaz" Backend Project: ⭐️ Gratitude Journal
### Documentation:

### About
*An application whose main function is to allow a user to record daily notes of gratitude and a rating of their mood*

* *Mehlia Rahman*
* *Billie Redwood*
* *Rashad Ramali*
* *Joseph Carpentieri*
* *Thomas McLaughlin*



### The project's aims


### The names and versions of any libraries used
* Spring Boto Starter Data JPA
* Spring Boot Starter Web
* Spring Boot devtools
* Postgresql


### Step-by-step setup instructions

1. Git clone from github repo: `git@github.com:mclaughlin111/BNTA_BackendProject_GratitudeJournal.git`
2. Open up `GratitudeJournal`folder in intellij (or IDE of choice).
3. Check dependencies for spring dependencies specified above in pom.xml - if not installed it will not run correctly.
4. Create a postgreql database called gratitude_journal in terminal.
5. Run GratitudeJournal.java application.
6. Test mapping routes in API server of choice.



### A full list of example routes (or a link to one) including:

- Full urls including placeholders for variables (localhost:8080/users/:id)
- Permitted requests for each route (GET, POST, etc)
- Examples of permitted requests where appropriate
- Examples of responses
- Routes should be organised by route and not by request method

-


## MVP - Gratitude Journal

* Add a Journal Entry ✅
	* Enter day of the week ✅
	* Input mood rating	for the day ✅
	* Record a gratitude entry in the journal ✅
	

* Display all Journal Entries ✅
* Update Journal Entry ✅
* Delete Journal Entry ✅


## Extension I - User
* Create a User ✅
* Update User Credentials
* Delete User ✅

## Extension II - Filtering

* Filter Journal Entries by `Weekday`
* Filter Journal Entries by `userId` ✅
* Filter Journal Entries by `moodRating`

## Extension III - up-to-5 Journal Entries

* Upon 5 Journal Entries for a single day, allow no additional entries and show status of Journal as `COMPLETE`
* Write a method that calculates a weekly average from a users `MoodRating` and returns a score

## Extension IV - Reward Streaks & User Incentive
* Create a database of motiviational quotes
* Write a method that returns a motivational quote to a user on a random basis
	* Send message directly to a users email address
	* extend method to only send motivational quotes to users below a certain MoodRating or below a specific `JournalEntry` average 
* Create a 'Streak' system that rewards users for continued daily usage at certain milestones (i.e. 3 days, 1 week, 1 month) with a virtual ⭐️ point system.


-

**Gratitude Journal**
**Class** Diagram
![ClassDiagram](https://github.com/mclaughlin111/BNTA_BackendProject_GratitudeJournal/assets/47330113/e12a3ed9-67cb-4444-bb55-e81320860e70)

**Entity Relationship** Diagram
![ERD_Diagram](https://github.com/mclaughlin111/BNTA_BackendProject_GratitudeJournal/assets/47330113/c7c5e2df-315e-4325-a127-0cc33de2c833)

-


#RESTful Routes

## JournalEntry Model

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



