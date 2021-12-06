#!/bin/bash
curl -X POST http://localhost:8080/api/v1/books \
  -H "Content-Type: application/json" \
  -d '{ "title": "my book" }' | jq .
