# My Personal Project

## WatchList

The project I would like to make for this term is a watchlist.
You can add a show or movie to your watchlist and mark it as
**To Watch**, **Watching**, or **Watched**. In your watchlist, you'll
be able to keep track of all the shows and movies you've watched, want to watch,
or are currently watching. You'll also be able to give a rating and write a comment for **Watched**
shows and movies.

This program will be useful for those who watch shows and movies.
As an individual who does this, I often find myself losing track of
what I'm watching, especially after an extended period of time. Therefore,
I'm sure there are many other people who have a similar problem too.

### User Stories
- As a user, I want to be able to add a show or movie to my watchlist
- As a user, I want to be able to view my shows and movies in my watchlist
- As a user, I want to be able to be able to keep track of my 
  shows and movies by being able to set a status to each of them in my 
  watchlist as **To Watch**, **Watching**, or **Watched**
- As a user, I want to be able to change the status of a show/movie
- As a user, I want to be able to sort my watchlist by their status
- As a user, I want to be able to keep track of where I left off for **Watching** shows and movies
- As a user, I want to be able to remove a movie from my watchlist
- As a user, I want to be able to save my watchlist to file
- As a user, I want to be able to be able to load my watchlist list from file

# Instructions for Grader

- You can generate the first required action related to adding Xs to a Y by pressing the "Add Movie"
  or "Add Show" button and filling in the required fields
- You can generate the second required action related to adding Xs to a Y by selected a Movie or Show
  already added and pressing the "Remove Movie/Show" button
- You can locate my visual component by the large "WATCHLIST" heading when you run the application
- You can save the state of my application by pressing the "Save" button
- You can reload the state of my application by pressing the "Load" button

# Phase 4: Task 2
- Mon Apr 10 18:19:58 PDT 2023 <br>
The movie "To Watch Movie" was added.
- Mon Apr 10 18:20:12 PDT 2023 <br>
The movie "Watching Movie" was added.
- Mon Apr 10 18:20:31 PDT 2023 <br>
The movie "Watched Movie" was added.
- Mon Apr 10 18:20:42 PDT 2023 <br>
The show "To Watch Show" was added.
- Mon Apr 10 18:20:51 PDT 2023 <br>
The show "Watching Show" was added.
- Mon Apr 10 18:21:01 PDT 2023 <br>
The show "Watched Show" was added.
- Mon Apr 10 18:21:05 PDT 2023 <br>
The movie "To Watch Movie" was removed.
- Mon Apr 10 18:21:06 PDT 2023 <br>
The movie "Watching Movie" was removed.
- Mon Apr 10 18:21:08 PDT 2023 <br>
The movie "Watched Movie" was removed.
- Mon Apr 10 18:21:10 PDT 2023 <br>
The show "To Watch Show" was removed.
- Mon Apr 10 18:21:11 PDT 2023 <br>
The show "Watching Show" was removed.
- Mon Apr 10 18:21:13 PDT 2023 <br>
The show "Watched Show" was removed.

# Phase 4: Task 3
If I had more time to work on this project, one substantive refactoring
I might do would be to incorporate an interface called "Watchable" and make
my Movie and Show class implement it. This is because I notice that there is a
close relationship between these two classes and there's a lot of repetition in my 
code. Creating an interface for my Movie and Show classes would reduce a lot of repetition.