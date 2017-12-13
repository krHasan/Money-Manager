# Money Manager
Money Manager is an application which can help you to keep record of your personal finance. Many of us don't maintain document of how much money we get in a month and how much expense because that seems very painy to us. This application will help us to keep a record of our every transaction.

# Download
Download Money-Manager for Linux, windows and Mac from [Here](https://drive.google.com/open?id=1p5izodhPK-JPNdc5HZo16nLhpiaszzvC) 

# Technologies
Here I use Model–view–controller(MVC) architecture to build this application. Tecnologies I used are
  - Java
  - JavaFX Framework
  - FXML
  - JavaScript
  - JQuery
  - json-simple
  - Collection Frameworks

# Workthrough
Money Manager have three main focusing window
1. Make A Transaction
2. Settings
3. Transaction History

When you Signed In, program shows the "Dashboard" window first. You can initialize your wallet balance using "Adjust Balance" button from Expense Tab in Make A Transaction window. 

Here I added some very short videos to show how can you use Money-Manager. I suggest, please see them to understand how it works.

### Sign In
<p align="center">
  <a href="https://youtu.be/Gz0cHR09qkY"><img src="/files/signin.jpg?raw=true"></a>
</p>

### Make A Transaction
In a transaction process there happens mainly two thing, one how to money get/add to account and other is how to expense/give from account. Money Manager have get money, expense, borrow, lend, bank transaction to fullfill those needs.
<p align="center">
  <a href="https://youtu.be/WCDlF-soUz4"><img src="/files/transaction.jpg?raw=true"></a>
</p>

### Settings
<p align="center">
  <a href="https://youtu.be/y3gMMBL95UA"><img src="/files/settings.jpg?raw=true"></a>
</p>

### Transaction History
<p align="center">
  <a href="https://youtu.be/yLFyqNvpSIU"><img src="/files/history.jpg?raw=true"></a>
</p>

## Development
Want to contribute? Great! Here is the process.

#### Environment Setup
 - [Install git](https://www.atlassian.com/git/tutorials/install-git)
 - Obviously you have jdk(8 or above) installed on your machine
 - An IDE (Eclipse, NetBeans etc)
 - Install JavaFX plugin on your IDE. Such as "e(fx)clipse" is the JavaFX plugin for Eclipse.
 - [Install](http://gluonhq.com/products/scene-builder) and setup Scene Builder (Search google how to add Scene Builder to your IDE. [Here](http://o7planning.org/en/10621/install-javafx-scene-builder-into-eclipse) is an example for Eclipse)

#### Start Development
 - Create a new JavaFX project named "Money-Manager" and delete its application package on `src`
 - Go to that folder in your workspace and initiate the git `$ git init ` with this command
 - Now [clone](https://help.github.com/articles/cloning-a-repository) the "Money-Manager" repository to that folder
 - Add `json-simple-1.1.1.jar` and `sqlite-jdbc-3.20.0.jar` as external jar file.

Now you are ready to develop. Happy Coding !!!

#### Deployment
In the case of deploy the application, these two sites help me most
 - [code.makery](http://code.makery.ch/library/javafx-8-tutorial/part7/)
 - [Oracle](https://docs.oracle.com/javafx/2/deployment/self-contained-packaging.htm)

License
----

MIT (do whatever you want to do)

Made by [krHasan](https://www.facebook.com/Bappikhandoker)
