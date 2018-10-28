# Micronaut Lambda Example

A small micronaut example I wrote to highlight an issue I was having with EntityManager in a serverless lambda app.

The issue is that when running the tests manually everything seems to work fine and the DI works properly, but when using the
AWS SAM CLI to run the function in a container it fails to find a configured binding for EntityManager.

```
sam invoke local "CreateResourceFunction" -e event.json
```
