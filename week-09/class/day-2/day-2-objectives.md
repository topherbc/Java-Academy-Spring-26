Icebreaker: Write a query to obtain your favorite song, album, or artist


Examples: 
SELECT
  artist,
  album,
  year
FROM
  music_table
WHERE
  artist = "King Gizzard and the Lizard Wizard"
  AND (album LIKE "%Microtonal%" OR album = "Flying Microtonal Banana");

or

SELECT
  artist,
  song_title,
  album,
  year
FROM
  music_table
WHERE
  year BETWEEN 1980 AND 1987;


1. SELECT
  artist
FROM
  YouTube
WHERE
  artist = 'Marco Bucci';

2. SELECT 
 artist,
 song_title,
 album
FROM
 funk_playlist
WHERE
 artist = "Con Funk Shun";

3. SELECT 
 artist 
FROM 
 artist_list_table 
WHERE 
 artist LIKE "%Alexander Rybak%"; //song fairytale

4. SELECT
Artist
FROM 
MySongs
WHERE
Artist = ‘lightning bolt’ AND BETWEEN 2000 AND 2010;

5. SELECT
 artist
FROM
 music_table
WHERE
 artists = ‘J. Cole’; //2014 Forest Hills Dr.

6. SELECT
 artist, 
 song_title,
 album
FROM
 my_playlist
WHERE
 artist = "Rod Wave";

7. SELECT 
    artist
FROM 
    music_table 
WHERE 
    year BETWEEN 2000 AND 2012;

8. SELECT
  artist
FROM
  MyPlaylist
WHERE
  Artist = "Asake"; //work of art

9. SELECT
 artist
FROM
 spotify
WHERE
 artist = 'Men I Trust'
AND album = 'Equus Asinus'
ORDER BY album DESC;

10. SELECT
 artist,
songtitle,
 album
FROM
 apple_music
WHERE
 artist = "lil uzi vert"; //feelings mutual

11. SELECT 
  artist
FROM
   spotify
WHERE
  album = ‘views’;

12. SELECT 
artist
FROM
music_playlist
WHERE
artist = 'mulatu astatke'; //Tizeta

13. SELECT
  artist
FROM
  Playlist
WHERE
  Artist = "Jamie Paige"; //constant companions deluxe

14. SELECT
 artist
FROM
 favorites
WHERE
artist = "A Tribe Called Quest"; //midnight marauders 

15. SELECT
artist
FROM 
Mangaka
WHERE
artist = "OH great!";


What did you learn yesterday?

1. CRUD - Create Read Update and Delete
2. SQL - Structured Query Language
3. MySQL - relational database
4. NoSQL - non-relational database
5. RDBMS - relational database management system
   1. MySQL
6. MySQL workbench - where we work with an RDBMS
7. SQL syntax, has commands in capital
8. SQL Commands
   1. SELECT
      1. column_name, column_name <- commas only show before last
      2. * <- all columns
      3. DISTINCT - returns only distinct values
      4. COUNT()
   2. FROM - determine table to pull data FROM
   3. WHERE
      1. value BETWEEN value AND value
      2. AND OR NOT
      3. LIKE
         1. % wildcard - check for any value
         2. 'a%' - anything that starts with a
         3. '%a' - anything that ends with a
         4. '%a%' - anything that contains a
   4. ORDER BY
      1. DESC
      2. ASC - default ascending
9. -- comments

Today's Objectives

1. SELECT
2. FROM
3. WHERE
4. ORDER BY
5. Aggregates
6. GROUP BY
7. HAVING
8. LIMIT

Agenda Today

1. Intro, Icebreaker, and Recap
2. You do exercise 2
3. Break
4. We do exercise 2
5. Break
6. We visit the zoo
7. Lunch
8. You learn aggregates
9. We learn aggregates
10. Aggregates exercise
11. Break
12. A quick trip to the zoo
13. Recap and Q&A


What did you learn today?

1. USE DB
2. Aggregate Functions
   1. COUNT()
   2. ROUND()
   3. CONCAT()
   4. MIN()
   5. MAX()
   6. AVG()
   7. SUM()
3. _ - one character wildcard
4. AS - alias
5. GROUP BY
6. HAVING - condition for aggregates
7. LIMIT
8. TINYINT
9. Boolean
