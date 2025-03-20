# Contributing to BugRaid Jenkins Plugin

Thank you for your interest in contributing to the BugRaid Jenkins Plugin! This document provides guidelines and instructions for contributing to the project.

## Code of Conduct

By participating in this project, you agree to abide by our Code of Conduct. Please read the [CODE_OF_CONDUCT.md](CODE_OF_CONDUCT.md) file for details.

## Development Setup

1. Fork the repository
2. Clone your fork:
   ```bash
   git clone https://github.com/YOUR_USERNAME/bugraid-jenkins-plugin.git
   ```
3. Set up your development environment:
   - Install Java 11 or higher
   - Install Maven 3.6 or higher
   - Install your preferred IDE (IntelliJ IDEA, Eclipse, or VS Code)

## Building the Plugin

```bash
mvn clean package
```

The plugin will be available in `target/bugraid-jenkins-plugin.hpi`.

## Running Tests

```bash
mvn test
```

## Local Development

1. Start a local Jenkins instance with the plugin:
   ```bash
   mvn hpi:run
   ```
2. Access Jenkins at `http://localhost:8080/jenkins`
3. Configure the plugin as described in the README

## Making Changes

1. Create a new branch for your feature:
   ```bash
   git checkout -b feature/your-feature-name
   ```
2. Make your changes
3. Write or update tests
4. Run the test suite
5. Commit your changes:
   ```bash
   git commit -m "Description of your changes"
   ```
6. Push to your fork:
   ```bash
   git push origin feature/your-feature-name
   ```
7. Create a Pull Request

## Code Style

- Follow the [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html)
- Use meaningful variable and method names
- Add comments for complex logic
- Keep methods focused and small
- Write unit tests for new functionality

## Pull Request Guidelines

1. Update the README.md if needed
2. Add tests for new functionality
3. Update the CHANGELOG.md
4. Ensure all tests pass
5. Update documentation if needed
6. Add appropriate labels to your PR

## Documentation

- Update relevant documentation for any changes
- Add Javadoc comments for public APIs
- Update the README.md if needed
- Add inline comments for complex logic

## Release Process

1. Update version in pom.xml
2. Update CHANGELOG.md
3. Create a release tag
4. Build the release
5. Create a GitHub release

## Getting Help

- Open an issue for bugs or feature requests
- Join our community chat
- Check the documentation

## License

By contributing, you agree that your contributions will be licensed under the project's Apache License 2.0.

Thank you for contributing to BugRaid Jenkins Plugin! 