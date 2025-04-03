# Java Javalin Tutorial Deploy on Blossom

A ready-to-deploy Java Javalin app to get you started quickly on [Blossom](https://blossom-cloud.com).

## Quick Start

```bash
# Install dependencies and build
mvn clean package

# Run the app
java -jar target/javalin-demo-1.0-SNAPSHOT.jar
```

Visit `http://localhost:3000` in your browser to see the demo application.

<details>
<summary>Additional Information</summary>

### Environment Variables
- `PORT`: Change the port (default: 3000)

### API Endpoints
```bash
# Get a greeting
curl http://localhost:3000/api/hello?name=John

# Echo a message
curl -X POST -H "Content-Type: application/json" \
     -d '{"message":"Hello"}' http://localhost:3000/api/echo
```
</details>
