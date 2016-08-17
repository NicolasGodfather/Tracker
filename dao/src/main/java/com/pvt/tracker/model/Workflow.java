package com.pvt.tracker.model;

import java.util.List;

/**
 * Realization
 *
 * @author Nicolas Asinovich.
 */
public class Workflow extends AbstractModel{

    private static final long serialVersionUID = 5893176726966363895L;

    private List<StatusType> statusTypes;
    private List<ModelType> modelTypes; //for list tasks
}
