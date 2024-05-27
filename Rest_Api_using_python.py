import pymongo

from flask import Flask
from flask import request, jsonify
from flask_cors import CORS

myClient = pymongo.MongoClient("mongodb://localhost:27017")
mydb = myClient['mydatabase']

myCul = mydb['demo']

app = Flask(__name__)
cors = CORS(app)
app.config["CORS_HEADERS"] = "Content-Type"

@app.route("/Push", methods = ["Post", "GET"])
def Push():
    content = request.get_json()
    myCul.insert_one(content)
    return "Pushing the data"


@app.route("/Update", methods = ["Post", "GET"])
def Update():
    content = request.get_json()
    myVal = {"$set": {"Score": content['Score']}}
    myCul.update_one({"Name": content["Name"]}, myVal)
    return "Updating the data"


@app.route("/Delete", methods = ["Post", "GET"])
def Delete():
    content = request.get_json()
    myCul.delete_one({"Name": content["Name"]})
    return "deleting the data"

@app.route("/Pulling", methods = ["Post", "GET"])
def Pull():
    content = request.get_json()
    ViewQuery = []
    Pulleddata = myCul.find({"Name": content["Name"]})

    for i in Pulleddata: 
        ViewQuery.append({"Name":i["Name"], "Score":i["Score"]})
    
    return jsonify(ViewQuery)


if __name__ == "__main__":
    app.run()