import os
from flask import Flask

app = Flask(__name__)
port = int(os.getenv("PORT", 8080))

@app.route('/')
def hello_world():
return 'Hello World! I am instance ' + str(os.getenv("CF_INSTANCE_INDEX", 0))

if __name__ == '__main__':
    # Run the app, listening on all IPs with our chosen port number
    app.run(host='0.0.0.0', port=port)
