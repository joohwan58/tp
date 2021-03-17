# User Guide

## Introduction

`FridgeFriend` is an app for managing food in the fridge, optimised for use via a Command Line Interface (CLI).
If you can type fast, `FridgeFriend` can track your cold or frozen groceries faster and easier than any other apps.
It is written in Java, and has more than 1.5kLoC.

## Quick Start

1. Ensure that you have Java 11 or above installed.
1. Download the latest version of `FridgeFriend` from [here](update_link_here_after_release).

## Features

{Give detailed description of each feature}
**Notes about the command format:**

* Words in UPPER_CASE are the parameters to be supplied by the user.\
  e.g. `add FOOD_NAME`, `FOOD_NAME` is a parameter which can be used as `add chicken`.
  
### Adding a food item: `add`

Adds a food item into the fridge.

Format: `add FOOD_NAME /cat FOOD_CATEGORY /exp EXPIRY_DATE /loc LOCATION_IN_THE_FRIDGE`

* The `FOOD_NAME` can be the name of a food but not an empty description.
* The `FOOD_CATEGORY` can be the basic food groups otherwise it will be categorised as others.
* The `EXPIRY_DATE` must be in the format `dd-mm-yyyy`.
* The `LOCATION_IN_THE_FRIDGE` can be a general compartment in a fridge.

Additional info:

* Basic Food Groups:`MEAT`, `SEAFOOD`, `EGG`, `DAIRY`, `VEGETABLE`, `FRUIT`,
  `BEVERAGE`, `COOKED_DISH`, `READY_TO_EAT`, `FROZEN`, `OTHERS`
* Basic fridge location: `FREEZER`, `UPPER_SHELF`, `MIDDLE_SHELF`, `LOWER_SHELF`, 
  `DRAWERS`, `FRIDGE_DOOR`, `OTHERS`

Example of usage:

```
>> add chicken /cat meat /exp 30-06-2021 /loc lower_shelf
Great! I have added chicken into your fridge.
Details: Food name: chicken, category: MEAT, expiry: 30-06-2021, stored in: LOWER_SHELF
```

### Display the list of all foods: `list`

Displays the full list of food items stored in the fridge.

Format: `list`

* There should not be any descriptions after keyword `list`.  

Example of usage:

```
>> list
Here are the items in your fridge:
    1. chicken [MEAT]
    2. grouper [SEAFOOD]
```

### Display the list of foods by category: `list <CATEGORY>`

Displays the list of food items under specified category stored in the fridge.

Format: `list CATEGORY_NAME`

* The `CATEGORY_NAME` can only be recognized if it is in the pre-defined categories:
`VEGETABLE, FRUIT, MEAT, SEAFOOD, EGG, DAIRY, BEVERAGE, COOKED_DISH, READY_TO_EAT, FROZEN, OTHER`
* The `CATEGORY_NAME` is case-insensitive.
* If other category names are detected, `FridgeFriend` would give an error message.

Example of usage:

*Situation 1: There is one food called chicken under MEAT category.*

```
>> list MEAT
These are the MEAT in your fridge:
	1. chicken
```

*Situation 2: There are no foods under READY_TO_EAT category.*

```
>> list ready_to_eat
These are the READY_TO_EAT in your fridge:
```

### Remove a food item: `remove`

Removes a food item based on its index.

Format: `remove INDEX`

* The `INDEX` must be a valid index.
* If the `INDEX` is out of bounds, `FridgeFriend` will give an error message.

Example of usage:
```
>> list
Here are the items in your fridge:
        1. chicken [MEAT]
        2. mango [OTHER]
        3. milk [OTHER]

>> remove 2
Noted! I've removed mango from your fridge.
Now you have 2 food in the fridge.

>> list
Here are the items in your fridge:
        1. chicken [MEAT]
        2. milk [OTHER]
```

### Search: `search`

Checks if a certain food item is inside the fridge, and if the item is found, informs user of the food's storage location.

Format: `search FOOD_NAME`

* The `FOOD_NAME` can be the name of a food but not an empty description.
* The command requires the user to input the exact name of the food item `FOOD_NAME` to be searched for.
  The names of food items stored in the fridge can be determined with `list`. 
* If there are multiple items with the same name in the fridge, only the first item added to the fridge
  in order of the output of `list` will be returned.

Example of usage:

*In this example, Fridge contains only one item `grouper` stored in the `FREEZER` location.*

```
>> search grouper
You have grouper stored in FREEZER of your fridge.

>> search oyster
You do not have oyster in your fridge.
```

### List expiring foods: `expiring`

Displays a list of food items that are expiring within a week.

Format: `expiring`

Example of usage:

```
>> expiring
These are the food expiring in the next week:
1. Food name: chicken wings, category: MEAT, expiry: 21-03-2021, stored in: MIDDLE_SHELF
```

### Get help message: `help`

Prints a list of available commands and formats.

Format: `help`

Example of usage:

```
>> help
These are the list of available commands:
        add foodName /cat categoryName /exp dd-mm-yyyy /loc storageLocation
        list
        list categoryName
        remove index
        search searchString
        expiring
        help
        bye

This is the list of food categories:
        [VEGETABLE, FRUIT, MEAT, SEAFOOD, EGG, DAIRY, BEVERAGE, COOKED_DISH, READY_TO_EAT, FROZEN, OTHER]

This is the list of storage locations:
        [FREEZER, UPPER_SHELF, MIDDLE_SHELF, LOWER_SHELF, DRAWERS, FRIDGE_DOOR, OTHER]
```

### Exit the application: `bye`

Exits the application.

Format: `bye`

Example of usage:

```
>> bye
Bye! Hope to see you again soon!
```

## FAQ

**Q**: How do I transfer my data to another computer?

**A**: Copy the `.jar` file along with `save` folder to the target computer and place them together into an empty folder.
As long as the target computer satisfies our project prerequisites, it can run with the saved data as before.

**Q**: What if I forget the correct format of a command?

**A**: You will get a tip if you use any of the command keywords incorrectly.
Plus, you are always welcomed to use `help` command.

**Q**: How do I report a bug?

**A**: You can either create a pull request or state in the issues.

## Command Summary

* Add food `add FOOD_NAME /cat FOOD_CATEGORY /exp EXPIRY_DATE /loc LOCATION_IN_THE_FRIDGE`
* List food `list`
* List food by category `list CATEGORY_NAME`
* Remove food `remove INDEX`
* Search for food `search FOOD_NAME`
* List expiring foods `expiring`
* Get help message `help`
* Exit application `bye`
