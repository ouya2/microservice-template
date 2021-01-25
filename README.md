# Microservice-template
===============================================================
- - -
This project contains a micro-service template built using Gradle and Spring Boot libraries. 

The template is designed to work out-of-the-box, by using Spring Boot auto-configuration feature. Where required, sensible
defaults were chosen to ensure that the application can start as soon as it is created (as per below instructions).

System Requirements
-------------------
- - -

To use this template, you will need the following to be already installed on your machine:

- Git
- Gradle
- JDK 8 (it has been tested with Coretto 11)

Quick Start
-----------
- - -

To create a project using this template, follow these steps:
```
git clone https://github.com/ouya2/microservice-template.git [my-microservice]

cd [my-microservice]

rm -rf .git

git init
git add --all
git commit -m "Initial Commit"
```
Then create a new blank repository in your git server of choice, and then perform the following two steps:
```sh
git remote add origin https://<user>@<service_domain>/<path>/<repo_name>.git
git push -u origin master
```

The above clones the microservice-template repository to your machine and places it into your specific micro-service
project directory. You need to then remove the `.git` directory as it corresponds to the template repository not your
project repository. Finally, initialise a new Git repository for your project.

**Note:** You need to supply values to the top 6 properties in the `ext` block at the top of `build.gradle`:

```groovy
ext {
	clonedLongName = 'My Long Name API'
	clonedDescription = 'My brief API description'
	clonedAssetOwner = 'myTeamName'
	clonedAssetGroup = 'myTrainOrTribe'
	clonedPath = 'my-shrtname'
	clonedGroupId = 'au.com.acne.' + clonedAssetGroup + '.' + clonedPath
	clonedArtifactId = clonedAssetGroup + '-' + clonedPath + '-api'
	clonedArtifactVersion = version
	clonedPackageName = 'au.com.acne.' + clonedAssetGroup + '.' + clonedPath.replaceAll('-', '.')
	clonedFrom = '2.1.16'
}		
```
Although you can really set anything you like here, there are some recommendations that might make your life easier in the long run.
#### clonedLongName
This is your intended service name.
#### clonedDescription
A short summary of what the API is for.
#### clonedAssetOwner
Essentially the name of your team.
#### clonedAssetGroup
Generally the name of the business unit paying the bills: it might be your train, sometimes your tribe, or some
other reasonably long-lasting, stable business entity. Try to keep this one short, because it'll be part of your package name.
#### clonedPkg
Now this one is very important, because it is the actual package name of your asset, and the base name of your artifact.
If you name your `clonedAssetGroup` "mpc" and your`clonedPath` as "pob-lease", then your package would end with `mpc.poblease`
and your artifacts would be `mpc-pob-lease-api`. We generally take the artifactId to be our basic asset tag. We would name
our source repository `mpc-pob-lease-api`, our stacks `mpc-poblease-api-pt01` etc. 
Notice when the hyphen is included and when it isn't.
#### clonedGatewayPath
what you would register in the Kong Gateway as your APIs path eg '/post-box/v1'

### Running your application
- - -

The application created from this template contains everything you need to start it without any additional configuration.

Run the following `gradle` command from the command line in the root directory of your project:

```
./gradlew bootRun
```

First time you do this, it might take some time as it needs to download library dependencies from the corporate Nexus
repository. It will also install a local version of Gradle v2.4 in your application's home directory.

Once started, go to [http://localhost:8080/_admin/health](http://localhost:8080/_admin/health) in your browser.
You should see the following result:

```
{
  "status" : "UP"
}
```

You are now ready to develop your micro-service!

### Micro-service Structure
- - -

The project structure that comes by default with the template is as follows:

```
build.gradle                   -- Gradle build script
gradle.properties              -- Properties needed by build.gradle, e.g. dependency versions, etc.
gradle/                        -- Gradle wrapper files (currently configured for Gradle v2.4)
  wrapper/
    gradle-wrapper.jar
    gradle-wrapper.properties
gradlew                        -- Linux shell script to run gradle wrapper
gradlew.bat                    -- Windows script to run gradle wrapper
config/checkstyle/
  checkstyle.xml               -- Checkstyle rules
  checkstyle-suppressioins.xml -- Default (AP) checkstyle suppression rules
src/
  functional/
    groovy/                    -- functional Groovy source code goes here
    resources/                 -- Application properties, etc. go here
  main/
    java/                      -- Application Java source code goes here
    resources/                 -- Application properties, etc. go here
  test/
    groovy/                    -- Unit test Groovy code goes here
    java/                      -- Unit test Java code goes here
    resources/                 -- Properties required for tests go here
```

The template comes with a default `au.com.acne.microservice.App` class that bootstraps the application. In general,
you should not need to change or move this class.

```
package au.com.acne.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

@SpringBootApplication
public class App extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(App.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
```

The `main` method allows the application to be bootstrapped and executed as a stand-alone JAR. The `configure`
method ensures that the application can be packaged as a deployable WAR, which can then be deployed to a servlet
container, e.g. Apache Tomcat.

### Next Step
- - -

You will most likely begin development of your application by adding a controller to it. This is how you can go about
doing this.

```
package au.com.acne.microservice.greeting;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

  @RequestMapping("/greeting")
  public Greeting get() {
    return new Greeting("Default greeting");
  }
}
```

The important thing to note about the above code is that the controller which is placed under the `microservice` package. This
is important as all code should be placed downstream of the package where the `App` class which is defined as that's where
the component scanning will start from.

Also, because it is using a `@RestController` annotation instead of the `@Controller`, the methods don't need to be
annotated with `@ResponseBody`.

Other features that are available out of the box (i.e. without needing to add other dependencies) are:

- Externalised configuration
- JSR-303 Bean Validation
- Jackson backed JSON serializer/deserializer
- Exception handling that return proper standard JSON responses
- Health and other metrics endpoints 
- Embedded Tomcat container
- and much more...


