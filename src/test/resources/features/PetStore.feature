Feature: Testing different request on PetStore Application


Scenario: Check if the petstore application can be accessed

When User sends the get request to the pet endpoint,they must get back valid 200 status code

Scenario Outline: Create a new Pet and verify the pet has created

When I create a new pet with categoryId <categoryId>,categoryName <categoryName>,name <name>,status <status>,tagId <tagId>,tagName <tagName>,photoUrls <photoUrls> options
Then I verify the pet is created using name <name> and status <status>

Examples:

|categoryId |categoryName    | name      | status    | tagId   | tagName           | photoUrls         |
|1L         |  Dogs_love     | pretty    | available | 100L    | Prettydogabde     | "www.doglove.com" |
#|1L        |  Dogs_love1   | pretty1    | available | 100L    | Prettydogabde1    | "www.doglove1.com" |


Scenario Outline: Update the newly created Pet and verify the pet name and status has updated

When Pick up newly created petname <name>,update name to <updatedname> and status to <status> check
Then I verify the pet is updated using name <updatedname> and status <status>

Examples:

| name              | status         | updatedname           |
| pretty            | available      | pretty_doggie         | 
#| pretty1          | available      | pretty1_doggie      | 


Scenario Outline: Delete the newly created Pet and verify the pet has deleted

When I pick up newly updated pet name <name>, and status <status> and delete the pet
Then I verify the pet is deleted using by sending name <name> and status <status>

Examples:

| name                    | status         |
| pretty_doggie           | available      |
#| pretty1_doggie1         | available      |




