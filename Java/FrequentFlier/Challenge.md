# Frequent Fliers Program

## Background
Today we're writing software to manage an airline frequent-flier program

Frequent filer programs are full of interesting business rules around who has earned what kind of status,
and what sort of perks that status entitles them to.

Our airline has 3 tiers Bronze, Silver and Gold, each with different perks and stat milestones
required for a member to achieve that tier.

### The business logic
What we need to implement is the code to determine if a member is eligible for a given tier.

The *rule* for this is a bit convoluted:

For a given level a *member* must have flown the required number of *miles* **or** the required number of *segments*
**In addition** they must have spent the required number of *dollars* on tickets.

A member *may* collect some of their miles from traveling with partner airlines, but these "*partner miles*" are capped at 10,000.

A helpful developer has already written these requirements down for you in a spec. See RuleTest.java

## The challenge

For this challenge, please consider in what ways we can implement the above rule. What are the pros and cons to say
putting it on the *Customer* model, or the *RewardTier* abstract class? Or would you put the code somewhere else completely?

You have only been provided with small snippets of the code, how would the rest of the system influence your choice? For instance the size of the *Customer* model?

And finally I would like you to consider the test code. Is there any interesting quality about these test you want to highlight?
Pros and cons compared to other styles of test code?

