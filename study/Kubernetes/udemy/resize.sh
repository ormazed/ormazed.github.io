# 접속방법 정리

## gcloud 접속
gcloud auth login
gclooud config set project theta-style-403004
./increase.sh




```
#!/bin/bash

# reszie : 3 to 0
echo "reszie : 3 to 0"
gcloud container clusters resize --zone us-central1-a in28minutes-cluster --num-nodes=0
echo "done"

# reszie : 0 to 3
# echo "reszie : 0 to 3"
# gcloud container clusters resize --zone us-central1-a in28minutes-cluster --num-nodes=3
# echo "done"
```