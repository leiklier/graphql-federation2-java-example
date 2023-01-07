# Blog API (GraphQL super-graph)

This repository serves as an example on how to make a supergraph in GraphQL using Apollo Federation 2 and DGS-Framework (Java).

Generate the supergraph by stitching together the subgraph schemas:

```
    $ ./generate_supergraph.sh
```

The script requires [Apollo Rover CLI](https://www.apollographql.com/docs/rover/) installed (`rover`) and available in your `$PATH`. 

Start everything in development mode locally on your computer by running:

```bash
    $ docker compose up
```

The services use hot module replacement. After making changes to the source code in either of the services, simply save and your changes will be built & compiled. 

After making changes to your schema(s), you will have to re-generate the supergraph.