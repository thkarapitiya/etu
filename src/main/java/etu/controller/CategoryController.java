
package etu.controller;

import etu.entity.Category;
import etu.controller.util.JsfUtil;
import etu.controller.util.JsfUtil.PersistAction;
import etu.enums.CategoryType;
import etu.sessionbean.CategoryFacade;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("categoryController")
@SessionScoped
public class CategoryController implements Serializable {

    @EJB
    private etu.sessionbean.CategoryFacade ejbFacade;
    private List<Category> items = null;
    private List<Category> areas = null;
    private List<Category> triags = null;
    private List<Category> conditions = null;
    private Category selected;
    private String label;

    public CategoryController() {
    }

    public Category getSelected() {
        return selected;

    }

    public List<Category> getAreas() {
        if (areas == null) {
            areas = listCategories(CategoryType.Area);
        }
        return areas;
    }

    public List<Category> getTriageCategories() {
        if (triags == null) {
            triags = listCategories(CategoryType.TriageCategory);
        }
        return triags;
    }

    public List<Category> getPatientConditions() {
        if (conditions == null) {

            conditions = listCategories(CategoryType.PatientCondition);
        }
        return conditions;

    }

    private List<Category> listCategories(CategoryType type) {
        String j;
        Map m = new HashMap();
        m.put("t", type);
        j = "select c from Category c where c.type=:t order by c.ename";
        return getFacade().findBySQL(j, m);
    }

    public void setAreas(List<Category> areas) {
        this.areas = areas;
    }

    public void setSelected(Category selected) {
        this.selected = selected;

    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private CategoryFacade getFacade() {
        return ejbFacade;
    }

    public Category prepareCreate() {
        selected = new Category();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("Created"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("Updated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("Deleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Category> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("Error"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("Error"));
            }
        }
    }

    public Category getCategory(java.lang.Long id) {
        return getFacade().find(id);
    }

    public List<Category> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Category> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    

    public void setTriags(List<Category> triags) {
        this.triags = triags;
    }

    

    public void setConditions(List<Category> conditions) {
        this.conditions = conditions;
    }

    @FacesConverter(forClass = Category.class)
    public static class CategoryControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            CategoryController controller = (CategoryController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "categoryController");
            return controller.getCategory(getKey(value));
        }

        java.lang.Long getKey(String value) {
            java.lang.Long key;
            key = Long.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Long value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Category) {
                Category o = (Category) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Category.class.getName()});
                return null;
            }
        }

    }

}
