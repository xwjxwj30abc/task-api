package zx.soft.task.api.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import zx.soft.task.api.domain.Task;

/**
 * 任务数据接口
 *
 * @author wanggang
 *
 */
public interface TaskMapper {

	/**
	 * 插入任务
	 */
	public void insertTask(Task task);

	/**
	 * 删除任务
	 */
	@Delete("DELETE FROM `internet_tasks` WHERE `identify` = #{0}")
	public void deleteTask(String identify);

	/**
	 * 查询任务
	 */
	@Select("SELECT `identify`,`keywords`,`source_ids`,`start_time`,`end_time` FROM `internet_tasks` WHERE `identify` = #{0}")
	public Task selectTask(String identify);

	/**
	 * 修改任务
	 */
	@Update("UPDATE `internet_tasks` SET `keywords` = #{keywords},`source_ids` = #{source_ids},`start_time` = #{start_time},"
			+ "`end_time` = #{end_time},`lasttime` = NOW() WHERE `identify` = #{identify}")
	public void updateTask(Task task);

}
