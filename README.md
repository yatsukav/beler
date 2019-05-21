# BELeR
**BÉLeR** is [acronym](https://en.wikipedia.org/wiki/Acronym) of Backendless Resume.
This is template/skeleton of resume with portfolio for html hosting like GitHub Pages.
You should have base html/css skills to use it.

TODO: add badges (license, ci, code coverage)

TODO: add life examples

## User Guide 
### Project Structure
```
+---index.html
+---beler.js
+---projects.json
\---projects
    +---prj1
    |   +---data.json
    |   +---content.html
    |   +---image1.png
    |   +---...
    |   \---imageN.png
    \---prjN
        \---(same as prj1)
```
Where:
* _index.html_ – main page
* _beler.js_ – adds portfolio to main page
* _projects.json_ – contains list of projects (name, tags, directory) and appearance settings
* _projects_ – directory with projects' directories from _projects.json_
* _prj1 ... prjN_ – projects' directories from _projects.json_
* _data.json_ – appearance settings of project gallery
* _content.html_ – project content
* _image1.png ... imageN.png_ – images project gallery from _data.json_

### projects.json
```json
{
  "showTags": true,
  "projects": [
    {
      "path": "projects/prj1",
      "name": "BELeR CV",
      "description": "Resume template written in Scala.JS",
      "tags": ["scala", "web", "figma"],
      "thumbnail": "logo.jpg"
    },
    ...
    {
      "path": "projects/prjN",
      ...
    }
  ]
}
```
Where:
* _showTags_ – show tags filter list before portfolio
* _projects_ – list with projects data
* _path_ – project directory path
* _name_ – project name
* _description_ – project short description
* _tags_ - project tags
* _thumbnail_ - image in project _dir_

### data.json
```json
{
  "content": "content.html",
  "images": ["img1.png", "img2.jpg", "img3.jpeg"],
  "thumbnails": ["img1.min.jpg", "img2.min.jpg", "img3.min.jpg"]
}
```
Where:
* _content_ – file name with html content
* _images_ – show tags filter list before portfolio
* _thumbnails_ – small size of _image_ to speed up page loading

### How get nice resume/cv
1. Fill your resume in _index.html_
2. Add projects to _projects_ directory and describe them in _content.html_
2. Set up appearance by modifying _projects.json_ and _data.json_
3. Add your favourite CSS Framework
4. ???
5. PROFIT!

## Developer Guide
### Technology stack
Language: _Scala 2.12_

Libraries: _Scala.JS_

Environment: _GitHub, SBT_

### Credentials
Licence: _GNU General Public License Version 3_

Developer: _Andrei Iatsuk_
