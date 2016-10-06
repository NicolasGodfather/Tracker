package com.pvt.tracker.dao.impl;

import com.pvt.tracker.beans.Status;
import com.pvt.tracker.beans.Workflow;
import com.pvt.tracker.dao.IWorkflowDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Realization
 *
 * @author Nicolas Asinovich.
 */
@Repository("workflowDao")
public class WorkflowDao extends BaseDao<Workflow> implements IWorkflowDao {

    @Autowired
    public WorkflowDao (SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    // TODO: 05.09.2016
    public List<Status> getStatuses (Workflow workflow) {
        String query = "SELECT * FROM " + "workflow_statuses ws WHERE ws.workflow_id = ? AND statuses.id = ws.status_id" + workflow.getId();
        return null;
    }
}
