#!/bin/bash
cd /usr/local/nginx/logs	
awk '{print $1}' myaccess.log| uniq -c| sort -rn
