#!/bin/bash

if (( $# != 3 )); then
    echo "Illegal number of arguments..."
    echo "USAGE: ./create_org_spaces_users.sh Org UserBaseName NumberOfUsers"
    exit 1
fi

if [[ -z "${CF_ADMIN}" ]]; then
  "Environment variable CF_ADMIN  is undefined"
   exit 1
fi

if [[ -z "${CF_ADMIN_PASSWORD}" ]]; then
  "Environment variable CF_ADMIN_PASSWORD  is undefined"
  exit 1
fi

if [[ -z "${CF_API_ENDPOINT}" ]]; then
  "Environment variable CF_API_ENDPOINT  is undefined"
  exit 1
fi

# Parameter $1 Organization
#           $2 User
#           $3 number of users
#
# ./create_org_spaces_users.sh TrainingOrg labuser 40
#

cf login -a $CF_API_ENDPOINT -u $CF_ADMIN -p $CF_ADMIN_PASSWORD --skip-ssl-validation -o system -s system

cf create-org $1


for i in `seq 1 $3`;
  do
    # cf create-user USERNAME PASSWORD
    cf create-user $2_$i $2_$i
    # cf create-space SPACE [-o ORG]
    cf create-space -o $1 $2_$i
    # cf set-org-role USERNAME ORG ROLE
    cf set-org-role $2_$i $1 OrgManager
    # cf set-space-role USERNAME ORG SPACE ROLE
    cf set-space-role $2_$i $1 $2_$i SpaceManager
    # cf set-space-role USERNAME ORG SPACE ROLE
    cf set-space-role $2_$i $1 $2_$i SpaceDeveloper
  done
