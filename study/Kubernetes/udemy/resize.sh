#!/bin/bash

# reszie : 3 to 0
echo "reszie : 3 to 0"
gcloud container clusters resize --zone us-central1-a in28minutes-cluster --num-nodes=0
echo "done"

# reszie : 0 to 3
# echo "reszie : 0 to 3"
# gcloud container clusters resize --zone us-central1-a in28minutes-cluster --num-nodes=3
# echo "done"
