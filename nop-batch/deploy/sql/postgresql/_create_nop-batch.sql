
CREATE TABLE nop_batch_task_state(
  TASK_ID VARCHAR(32) NOT NULL ,
  FIELD_NAME VARCHAR(100) NOT NULL ,
  FIELD_TYPE INT4 NOT NULL ,
  STRING_VALUE VARCHAR(4000)  ,
  DECIMAL_VALUE NUMERIC(30,6)  ,
  LONG_VALUE INT8  ,
  DATE_VALUE DATE  ,
  TIMESTAMP_VALUE TIMESTAMP  ,
  VERSION INT8 NOT NULL ,
  CREATED_BY VARCHAR(50) NOT NULL ,
  CREATE_TIME TIMESTAMP NOT NULL ,
  UPDATED_BY VARCHAR(50) NOT NULL ,
  UPDATE_TIME TIMESTAMP NOT NULL ,
  constraint PK_nop_batch_task_state primary key (TASK_ID,FIELD_NAME)
);

CREATE TABLE nop_batch_record_result(
  TASK_ID VARCHAR(32) NOT NULL ,
  RECORD_KEY VARCHAR(200) NOT NULL ,
  RESULT_STATUS INT4  ,
  RESULT_CODE VARCHAR(100)  ,
  RESULT_MSG VARCHAR(500)  ,
  ERROR_STACK VARCHAR(4000)  ,
  VERSION INT8 NOT NULL ,
  CREATED_BY VARCHAR(50) NOT NULL ,
  CREATE_TIME TIMESTAMP NOT NULL ,
  UPDATED_BY VARCHAR(50) NOT NULL ,
  UPDATE_TIME TIMESTAMP NOT NULL ,
  constraint PK_nop_batch_record_result primary key (TASK_ID,RECORD_KEY)
);

CREATE TABLE nop_batch_task(
  SID VARCHAR(32) NOT NULL ,
  TASK_NAME VARCHAR(50) NOT NULL ,
  TASK_KEY VARCHAR(100) NOT NULL ,
  TASK_STATUS INT4 NOT NULL ,
  START_TIME TIMESTAMP  ,
  END_TIME TIMESTAMP  ,
  TASK_PARAMS VARCHAR(4000)  ,
  WORKER VARCHAR(100) NOT NULL ,
  INPUT_FILE_ID VARCHAR(32)  ,
  RETRY_COUNT INT4 NOT NULL ,
  RESULT_STATUS INT4  ,
  RESULT_CODE VARCHAR(100)  ,
  RESULT_MSG VARCHAR(500)  ,
  ERROR_STACK VARCHAR(4000)  ,
  COMPLETED_INDEX INT8  ,
  READ_COUNT INT8  ,
  WRITE_COUNT INT8  ,
  PROCESS_COUNT INT8  ,
  SKIP_COUNT INT8  ,
  VERSION INT8 NOT NULL ,
  CREATED_BY VARCHAR(50) NOT NULL ,
  CREATE_TIME TIMESTAMP NOT NULL ,
  UPDATED_BY VARCHAR(50) NOT NULL ,
  UPDATE_TIME TIMESTAMP NOT NULL ,
  REMARK VARCHAR(200)  ,
  constraint PK_nop_batch_task primary key (SID)
);

CREATE TABLE nop_batch_file(
  SID VARCHAR(32) NOT NULL ,
  FILE_NAME VARCHAR(500) NOT NULL ,
  FILE_PATH VARCHAR(2000) NOT NULL ,
  FILE_LENGTH INT8 NOT NULL ,
  FILE_CATEGORY VARCHAR(100) NOT NULL ,
  FILE_SOURCE VARCHAR(10) NOT NULL ,
  CURRENT_TASK_ID VARCHAR(32) NOT NULL ,
  PROCESS_STATE INT4 NOT NULL ,
  ACCEPT_DATE DATE NOT NULL ,
  VERSION INT8 NOT NULL ,
  CREATED_BY VARCHAR(50) NOT NULL ,
  CREATE_TIME TIMESTAMP NOT NULL ,
  UPDATED_BY VARCHAR(50) NOT NULL ,
  UPDATE_TIME TIMESTAMP NOT NULL ,
  REMARK VARCHAR(200)  ,
  constraint PK_nop_batch_file primary key (SID)
);


      COMMENT ON TABLE nop_batch_task_state IS '批处理任务状态变量';
                
      COMMENT ON COLUMN nop_batch_task_state.TASK_ID IS '主键';
                    
      COMMENT ON COLUMN nop_batch_task_state.FIELD_NAME IS '变量名';
                    
      COMMENT ON COLUMN nop_batch_task_state.FIELD_TYPE IS '变量类型';
                    
      COMMENT ON COLUMN nop_batch_task_state.STRING_VALUE IS '字符串值';
                    
      COMMENT ON COLUMN nop_batch_task_state.DECIMAL_VALUE IS '浮点值';
                    
      COMMENT ON COLUMN nop_batch_task_state.LONG_VALUE IS '整数型';
                    
      COMMENT ON COLUMN nop_batch_task_state.DATE_VALUE IS '日期值';
                    
      COMMENT ON COLUMN nop_batch_task_state.TIMESTAMP_VALUE IS '时间点值';
                    
      COMMENT ON COLUMN nop_batch_task_state.VERSION IS '数据版本';
                    
      COMMENT ON COLUMN nop_batch_task_state.CREATED_BY IS '创建人';
                    
      COMMENT ON COLUMN nop_batch_task_state.CREATE_TIME IS '创建时间';
                    
      COMMENT ON COLUMN nop_batch_task_state.UPDATED_BY IS '修改人';
                    
      COMMENT ON COLUMN nop_batch_task_state.UPDATE_TIME IS '修改时间';
                    
      COMMENT ON TABLE nop_batch_record_result IS '批处理记录结果';
                
      COMMENT ON COLUMN nop_batch_record_result.TASK_ID IS '主键';
                    
      COMMENT ON COLUMN nop_batch_record_result.RECORD_KEY IS '记录唯一键';
                    
      COMMENT ON COLUMN nop_batch_record_result.RESULT_STATUS IS '返回状态码';
                    
      COMMENT ON COLUMN nop_batch_record_result.RESULT_CODE IS '返回码';
                    
      COMMENT ON COLUMN nop_batch_record_result.RESULT_MSG IS '返回消息';
                    
      COMMENT ON COLUMN nop_batch_record_result.ERROR_STACK IS '错误堆栈';
                    
      COMMENT ON COLUMN nop_batch_record_result.VERSION IS '数据版本';
                    
      COMMENT ON COLUMN nop_batch_record_result.CREATED_BY IS '创建人';
                    
      COMMENT ON COLUMN nop_batch_record_result.CREATE_TIME IS '创建时间';
                    
      COMMENT ON COLUMN nop_batch_record_result.UPDATED_BY IS '修改人';
                    
      COMMENT ON COLUMN nop_batch_record_result.UPDATE_TIME IS '修改时间';
                    
      COMMENT ON TABLE nop_batch_task IS '批处理任务';
                
      COMMENT ON COLUMN nop_batch_task.SID IS 'SID';
                    
      COMMENT ON COLUMN nop_batch_task.TASK_NAME IS '任务名';
                    
      COMMENT ON COLUMN nop_batch_task.TASK_KEY IS '唯一Key';
                    
      COMMENT ON COLUMN nop_batch_task.TASK_STATUS IS '任务状态';
                    
      COMMENT ON COLUMN nop_batch_task.START_TIME IS '任务启动时间';
                    
      COMMENT ON COLUMN nop_batch_task.END_TIME IS '任务结束时间';
                    
      COMMENT ON COLUMN nop_batch_task.TASK_PARAMS IS '任务参数';
                    
      COMMENT ON COLUMN nop_batch_task.WORKER IS '执行者';
                    
      COMMENT ON COLUMN nop_batch_task.INPUT_FILE_ID IS '输入文件';
                    
      COMMENT ON COLUMN nop_batch_task.RETRY_COUNT IS '重试次数';
                    
      COMMENT ON COLUMN nop_batch_task.RESULT_STATUS IS '返回状态码';
                    
      COMMENT ON COLUMN nop_batch_task.RESULT_CODE IS '返回码';
                    
      COMMENT ON COLUMN nop_batch_task.RESULT_MSG IS '返回消息';
                    
      COMMENT ON COLUMN nop_batch_task.ERROR_STACK IS '错误堆栈';
                    
      COMMENT ON COLUMN nop_batch_task.COMPLETED_INDEX IS '已完成记录下标';
                    
      COMMENT ON COLUMN nop_batch_task.READ_COUNT IS '读数量';
                    
      COMMENT ON COLUMN nop_batch_task.WRITE_COUNT IS '写数量';
                    
      COMMENT ON COLUMN nop_batch_task.PROCESS_COUNT IS '处理数量';
                    
      COMMENT ON COLUMN nop_batch_task.SKIP_COUNT IS '跳过数量';
                    
      COMMENT ON COLUMN nop_batch_task.VERSION IS '数据版本';
                    
      COMMENT ON COLUMN nop_batch_task.CREATED_BY IS '创建人';
                    
      COMMENT ON COLUMN nop_batch_task.CREATE_TIME IS '创建时间';
                    
      COMMENT ON COLUMN nop_batch_task.UPDATED_BY IS '修改人';
                    
      COMMENT ON COLUMN nop_batch_task.UPDATE_TIME IS '修改时间';
                    
      COMMENT ON COLUMN nop_batch_task.REMARK IS '备注';
                    
      COMMENT ON TABLE nop_batch_file IS '批处理文件';
                
      COMMENT ON COLUMN nop_batch_file.SID IS '主键';
                    
      COMMENT ON COLUMN nop_batch_file.FILE_NAME IS '文件名';
                    
      COMMENT ON COLUMN nop_batch_file.FILE_PATH IS '文件路径';
                    
      COMMENT ON COLUMN nop_batch_file.FILE_LENGTH IS '文件长度';
                    
      COMMENT ON COLUMN nop_batch_file.FILE_CATEGORY IS '文件分类';
                    
      COMMENT ON COLUMN nop_batch_file.FILE_SOURCE IS '文件来源';
                    
      COMMENT ON COLUMN nop_batch_file.CURRENT_TASK_ID IS '当前处理任务';
                    
      COMMENT ON COLUMN nop_batch_file.PROCESS_STATE IS '处理状态';
                    
      COMMENT ON COLUMN nop_batch_file.ACCEPT_DATE IS '文件接收时间';
                    
      COMMENT ON COLUMN nop_batch_file.VERSION IS '数据版本';
                    
      COMMENT ON COLUMN nop_batch_file.CREATED_BY IS '创建人';
                    
      COMMENT ON COLUMN nop_batch_file.CREATE_TIME IS '创建时间';
                    
      COMMENT ON COLUMN nop_batch_file.UPDATED_BY IS '修改人';
                    
      COMMENT ON COLUMN nop_batch_file.UPDATE_TIME IS '修改时间';
                    
      COMMENT ON COLUMN nop_batch_file.REMARK IS '备注';
                    
