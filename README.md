## Available commands
Command to add user:
```bash
java -jar app.jar add -n John -s Doe -e example@email.com -r admin -r superviser -p 375292020327,375251234567
```

Command to edit user:
userId is a necessary parameter, all others are optional.
```bash
java -jar app.jar edit 1 -s Doesnot -e newExample@email.com -p 375333458205```
```

Command to find specific user (either by id or email; at least one option must be present):
```bash
java -jar app.jar find -i 1
```
```bash
java -jar app.jar find -e newExample@email.com
```

Command to list all users:
```bash
java -jar app.jar list
```

Command to remove user (by id only):
```bash
java -jar app.jar remove 1
```