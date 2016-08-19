package com.pvt.tracker.model.factory;

import com.pvt.tracker.model.enums.ModelType;
import com.pvt.tracker.model.modeltype.Comment;
import com.pvt.tracker.model.modeltype.AbstractModel;
import com.pvt.tracker.model.modeltype.Project;
import com.pvt.tracker.model.modeltype.Task;

/**
 * Realization Factory AbstractModel
 *
 * @author Nicolas Asinovich.
 */
public class ModelFactory {

    public static AbstractModel getModelFactory (ModelType modelType) {
        switch (modelType) {
            case COMMENT:
                return new Comment();
            case PROJECT:
                return new Project();
            case TASK:
                return new Task();
            default:
                throw new IllegalArgumentException("Unknown type AbstractModel");
        }
    }
}
