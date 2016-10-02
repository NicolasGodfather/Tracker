package com.pvt.tracker.services.impl;

import com.pvt.tracker.beans.Status;
import com.pvt.tracker.beans.Workflow;
import com.pvt.tracker.dao.IWorkflowDao;
import com.pvt.tracker.services.IWorkflowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Realization
 *
 * @author Nicolas Asinovich.
 */
@Service
@Transactional (propagation = Propagation.REQUIRED)
public class WorkflowService extends BaseService<Workflow> implements IWorkflowService<Workflow> {

    @Autowired
    private IWorkflowDao workflowDao;

    @SuppressWarnings ("unchecked")
    public List<Status> getStatuses (Workflow workflow) {
        return  workflowDao.getStatuses(workflow);
    }
}
