
if [[ $# != 4 ]]
then
        echo "Number of parameters not sufficient"
        exit 1
else
cd $1
mvn clean install -P$2
git init
if [[ "$4" == *"master" ]]
then
        git checkout master
 #       git pull origin master
if [[ "$3" == *"all" ]]
then
        git add .
        git commit -m "Added all the files to git repository"
	git pull origin master
        git push origin master
else
        git add "$3"
        git commit -m " "$3" file add to the git repository"
        git pull origin master
	git push origin master

fi

elif [[ "$4" != *"master" ]]
then
        #git pull origin master
        git checkout -b "$4"
#        git pull origin "$4"
if [[ "$3" == *"all" ]]
then
        git add .
        git commit -m "Added all the files to git repository"
	git pull origin "$4"
        git push origin "$4"

else
#        git add "$3"
        git add .
        git commit -m " "$3" file add to the git repository"
	git pull origin "$4"
        git push origin "$4"

fi

else
        echo "Thankyou"
        exit 1
fi
fi

