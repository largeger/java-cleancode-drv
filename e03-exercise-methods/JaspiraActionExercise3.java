import java.util.Map;

public class JaspiraActionExercise3<JaspiraAction> {
	class JaspiraAction {

		public static final String PROPERTY_MENU_PARENT = null;
		public static final String PROPERTY_TOOLBAR_PARENT = null;

		public JaspiraAction(Object actionResource, String menuparentname) {
			// TODO Auto-generated constructor stub
		}

		public String getName() {
			// TODO Auto-generated method stub
			return null;
		}

		public void increaseCounter() {
			// TODO Auto-generated method stub

		}

		public String getActionPropertyString(String propertyMenuParent) {
			// TODO Auto-generated method stub
			return null;
		}

		public Object getActionResource() {
			// TODO Auto-generated method stub
			return null;
		}

		public void addMenuChild(JaspiraAction current) {
			// TODO Auto-generated method stub

		}

		public void addToolbarChild(JaspiraAction current) {
			// TODO Auto-generated method stub

		}

	}

	private Map<String, ? super JaspiraAction> actions;

	/***
	 * Add a new Action to the manager.Returns true if the action is already
	 * existant. If the action is already registered, it is NOT replaced.
	 */

	public void addAction(JaspiraAction action) {
		String name = action.getName();
		JaspiraAction current = (JaspiraAction) actions.get(name);
		if (current == null) {
			// Action not present yet, add to list
			current = action;
			actions.put(name, current);
		}
		// Increase reference counter
		current.increaseCounter();
		// Add as child to the menu parent if given
		String menuparentname = current.getActionPropertyString(JaspiraAction.PROPERTY_MENU_PARENT);
		if (menuparentname != null) {
			// Check if the parent has already been registered
			JaspiraAction menuparent = getAction(menuparentname);
			if (menuparent == null) {
				menuparent = new JaspiraAction(current.getActionResource(), menuparentname);
				addAction(menuparent);
			}
			// register this action at its parent
			menuparent.addMenuChild(current);
		}
		// Add as child to the toolbar parent if given
		String toolbarparentname = current.getActionPropertyString(JaspiraAction.PROPERTY_TOOLBAR_PARENT);
		if (toolbarparentname != null) {
			// Check if the parent has already been registered
			JaspiraAction toolbarparent = getAction(toolbarparentname);

			if (toolbarparent == null) {
				// No, create it on the fly
				toolbarparent = new JaspiraAction(current.getActionResource(), toolbarparentname);
				addAction(toolbarparent);
			}
			// register this action at its parent
			toolbarparent.addToolbarChild(current);
		}

	}

	private JaspiraAction getAction(String menuparentname) {
		// TODO Auto-generated method stub
		return null;
	}
}
