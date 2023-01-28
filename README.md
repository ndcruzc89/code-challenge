# Code Challenge

## What is Code Challenge?
This is a backend application that through the REST endpoint <http://localhost:8081/houses> can query the publicly accessible external Ice And Fire API (See documentation at <https://anapioficeandfire.com/Documentation> ), in order to know information about each house and each character that it has.

Then the application consults <https://www.anapioficeandfire.com/api/houses> more specifically, to obtain the information of all the houses and according to this information the route <https://www.anapioficeandfire. com/api/characters/{id}>, which will be consulted if it is not null, to receive the character data for each house.

At the end, the application returns the list of houses ordered alphabetically, with the character data, if it has them. The backend response will be displayed at <http://localhost:8081/houses> as follows:

```json
[
    {
        "url": "https://www.anapioficeandfire.com/api/houses/1",
        "name": "House Algood",
        "region": "The Westerlands",
        "currentLord": null
    },
    {
        "url": "https://www.anapioficeandfire.com/api/houses/2",
        "name": "House Allyrion of Godsgrace",
        "region": "Dorne",
        "currentLord": {
            "url": "https://www.anapioficeandfire.com/api/characters/298",
            "name": "Delonne Allyrion",
            "gender": "Female"
        }
    },
    {
        "url": "https://www.anapioficeandfire.com/api/houses/3",
        "name": "House Amber",
        "region": "The North",
        "currentLord": null
    },
    {
        "url": "https://www.anapioficeandfire.com/api/houses/4",
        "name": "House Ambrose",
        "region": "The Reach",
        "currentLord": {
            "url": "https://www.anapioficeandfire.com/api/characters/141",
            "name": "Arthur Ambrose",
            "gender": "Male"
        }
    },
    {
        "url": "https://www.anapioficeandfire.com/api/houses/5",
        "name": "House Appleton of Appleton",
        "region": "The Reach",
        "currentLord": null
    },
    {
        "url": "https://www.anapioficeandfire.com/api/houses/6",
        "name": "House Arryn of Gulltown",
        "region": "The Vale",
        "currentLord": null
    },
    {
        "url": "https://www.anapioficeandfire.com/api/houses/7",
        "name": "House Arryn of the Eyrie",
        "region": "The Vale",
        "currentLord": {
            "url": "https://www.anapioficeandfire.com/api/characters/894",
            "name": "Robert Arryn",
            "gender": "Male"
        }
    },
    {
        "url": "https://www.anapioficeandfire.com/api/houses/8",
        "name": "House Ashford of Ashford",
        "region": "The Reach",
        "currentLord": null
    },
    {
        "url": "https://www.anapioficeandfire.com/api/houses/9",
        "name": "House Ashwood",
        "region": "The North",
        "currentLord": null
    },
    {
        "url": "https://www.anapioficeandfire.com/api/houses/10",
        "name": "House Baelish of Harrenhal",
        "region": "The Riverlands",
        "currentLord": {
            "url": "https://www.anapioficeandfire.com/api/characters/823",
            "name": "Petyr Baelish",
            "gender": "Male"
        }
    }
]
```

## Architecture
Below is the architecture of layers and classes as the application was built:

<div style="text-align:center;">
<img
  src="images\appArchitecture.png"
  alt="Arquitectura de la aplicación"
  caption="Arquitectura de la aplicación"
  width="700" >
</div>

## Requirements
- Java SE 17.
- Spring Boot 3.0.2 / Maven

## How to run the application?
1. Download the .rar file of the application and unzip it.
2. Open the ***code-challenge*** project in the IDE of your choice.
3. Run the ***CodeChallengeApplication.java*** file, located in the path ***src\main\java\co\segurocanguro\nelsoncruz\codechallenge\CodeChallengeApplication.java***

## How to run test tests?
1. Open the file ***HousesServiceTest.java***, located in the path ***src\test\java\co\segurocanguro\nelsoncruz\codechallenge\service\HousesServiceTest.java***.
2. Run the file to verify all tests.
3. Run the test of the ***getAllHouses()*** method of the ***HousesServiceTest.java*** file. This verifies that calling the _getHouses()_ method of HousesClient returns the entire list of houses with just the keys and values of url, name, region, and currenLord.
4. Run the test of the ***getCharacter()*** method of the ***HousesServiceTest.java*** file. This verifies the following:
    - When passing as a parameter a house that has an empty currentLord key (in this case the Algood house) returns null.
    - That when calling the _getCharacters(id)_ method of HousesClient with an existing id within the list of houses (in this case 298 that belongs to the Allyrion house) it returns the respective information of that character with only the keys and values of url, name and gender.
    - That when passing as a parameter a house that has a currentLord key with a link to a character (in this case the Allyrion house), it returns the information regarding that character with only the keys and values of url, name and gender.
    - That the information that was previously returned is not null.
    - Verifies that the expected value of the Allyrion house character url is equal to the value resulting from the service.
    - Verify that the expected value of character name of the Allyrion house is equal to the value resulting from the service.
    - Verify that the expected value of the character gender of the Allyrion house is equal to the value resulting from the service.

## Author
---
Nelson Daniel Cruz Camelo
---








