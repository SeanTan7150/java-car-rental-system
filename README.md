# java-car-rental-system

## Project Structure

1. carrentalsystem

- This folder contains the main class that will be used to run the application.

2. Classes

- This folder contains all the classes we have such as Admin, Customer, and Booking.

3. DAO

- This folder contains all the Data Access Object classes.

4. Processes

- This folder contains all the process classes we have like LoginProcess.

5. UserInterface

- This folder contains all files related to our user interface. We will have 1 JFrame, and many JPanels.

6. Validators

- This folder contains all validators that will be used to validate users' input in order to make sure the input are inline with our Data Files' format.

- Some validators are general. An example is the DateTimeValidator. These validators can be used by other validators.

- Class-specific validators are validators that are to be used by their respective classes. For example, `CarValidator` will be used by the `Car` class. Inside `CarValidator`, there will be methods like `validateCarCreationInput`, `validateCarEditInput`, etc.

7. DataFiles

- We will ignore this folder in our GitHub repository.

## How to Build

### Install Apache Ant

- Check if Apache Ant is already installed by `ant -version`, if it is not installed, install it from [here](https://ant.apache.org/manual/install.html).

- Installation guide: [https://mkyong.com/ant/how-to-install-apache-ant-on-windows/](https://mkyong.com/ant/how-to-install-apache-ant-on-windows/)

### Configure Environment Variable

Configure `pathToDataFileDirectory` in `src/carrentalsystem/Environment.java` based on your own local directory path.

### Compile and Build

At the project root directory, run these commands to build the application

```shell
ant clean
ant prepare-libs
ant copy-resources
ant compile
ant dist
```

### Run

Head to dist directory, and run the following command:

```shell
java -jar CarRentalSystem.jar
```
