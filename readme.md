# Project Title: Ejercicio1

## Description
This is a Java project that uses Maven for dependency management. The project is part of a larger project called `ExamenProcesosHilos`. The main class of the project is `Main.java` which is located in the `es.cipfpbatoi.dam.psp.examen` package.

## Features
The `Main.java` class starts a new process using the arguments passed to it. It then waits for the process to complete. If the process does not complete within a specified timeout, it is destroyed. The output of the process is read and written to a file called `output.txt`. If the process completes successfully, the output is read from the standard output stream. If the process fails, the output is read from the error stream.

## Build
The project uses Maven for building. The source and target Java version is 17. The project encoding is UTF-8.

## Ignore Files
The project has a `.gitignore` file which specifies the files and directories that should not be tracked by Git. This includes build directories, IDE specific files, and OS specific files.

## Dependencies
The project does not specify any dependencies in the `pom.xml` file.

## Usage
To run the project, you can use the following command:
```
mvn exec:java -Dexec.mainClass="es.cipfpbatoi.dam.psp.examen.Main" -Dexec.args="arg1 arg2 arg3"
```
Replace `arg1 arg2 arg3` with the arguments you want to pass to the main class.

## Contributing
The project is currently being developed by `arturocandela`. If you want to contribute, please create a pull request.

## License
The project is licensed under the MIT License. You can find the full text of the license in the `license.txt` file.