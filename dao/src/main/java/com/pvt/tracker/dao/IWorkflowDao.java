package com.pvt.tracker.dao;

import com.pvt.tracker.beans.Status;
import com.pvt.tracker.beans.Workflow;

import java.util.List;

/**
 * Realization interface dao workflow
 *
 * @author Nicolas Asinovich.
 */
public interface IWorkflowDao extends IDao<Workflow> {

    List<Status> getStatuses(Workflow workflow);
}
