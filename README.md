# Custom Android Toolbar

Boilerplate project with customized toolbar that supports:

- Custom back image
- Custom back text
- Default title centered horizontally and easy editable.


###Setting up the toolbar in new project.
 
1. Copy the xml layout of the toolbar.
2. Include the toolbar.xml into the activity xml.
3. Let the Activity implement methods from MainActivity.java (Best to make Superclass).
    - setToolbar() initializes the toolbar, call this method in onCreate()
    - setBackText() 
    - setTitle()
  