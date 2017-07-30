package org.portal.enums;

import org.junit.Test;

/**
 * Created by Administrator on 7/30/2017.
 */
public class TestEnum {

    @Test
    public void test() {
        System.out.println(WorkflowStatusEnum.COMPLETED.name + ":" + WorkflowStatusEnum.COMPLETED.id);
        System.out.println(WorkflowStatusEnum.FAILED.name + ":" + WorkflowStatusEnum.FAILED.id);

        System.out.println(WorkflowStatusEnum.PENDING.name + ":" + WorkflowStatusEnum.PENDING.id);
        System.out.println(WorkflowStatusEnum.RUNNING.name + ":" + WorkflowStatusEnum.RUNNING.id);
    }

    public enum WorkflowStatusEnum {

        PENDING("PENDING", 1),
        RUNNING("RUNNING", 2),
        COMPLETED("COMPLETED", 3),
        FAILED("FAILED", 4);


        private String name;
        private int id;

        private WorkflowStatusEnum(String name, int id) {
            this.name = name;
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public int getId() {
            return id;
        }
    }
}
