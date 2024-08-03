Project Title: Multicalculator

Project Overview
Multicalculator is designed to achieve the following objectives:
-To calculate the simple mathematical operations like sum, difference, multiplication and division.

Git uses in the project:

1. Initializing the Repository
To start a new Git repository, I used following command:
git init
This command initializes a new Git repository in my project's directory.

2. Checking Repository Status
To check the current status of my repository, I used 
git status
This command displays the state of the working directory and the staging area, showing which changes have been staged, which haven't, and which files aren't being tracked by Git.

3. Adding Changes to Staging
To add changes to the staging area, I used
git add <filename> or simply git add . (to add all the files)


4. Committing Changes
git commit -m "commit message"
This command records changes to the repository with a descriptive message about what changes were made.

5. Pushing Changes to Remote Repository
git push -u origin main
This command sends your committed changes to the remote repository, ensuring that your local commits are reflected remotely.

Branching and Merging
Creating a New Branch
To create a new branch, I used:
git branch <branch-name>
This command creates a new branch called <branch-name>.

Switching Branches
To switch to a different branch, I used:
git checkout <branch-name>
This command switches your working directory to the specified branch.


Conclusion
Using Git's branching allows for effective collaboration and version control. By following this workflow, we can ensure a smooth development process, with clear tracking of changes and easy management of multiple features or fixes simultaneously.