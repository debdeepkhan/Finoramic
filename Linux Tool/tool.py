import os
import json

def main():
	dependencies = []
	success = []
	failure = []

	with open('python.json') as json_data:
		data = json.load(json_data)
		dependencies = data['Dependencies']

	for dependency in dependencies:
		status = os.system("pip install %s" %dependency)
		if status == 0:
			success.append(dependency)
		else:
			failure.append(dependency)

	print("Successfully Installed")
	print()
	if len(success) == 0:
		print("None")
	else:
		for each_success in success:
			print(each_success)

	print()
	print()

	print("Failed")
	print()
	if len(failure) == 0:
		print("None")
	else:
		for each_failure in failure:
			print(each_failure)

if __name__ == "__main__":
	main()