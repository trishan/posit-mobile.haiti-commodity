package org.hfoss.posit.android.experimental.plugin.commodity;

import java.sql.SQLException;

import org.hfoss.posit.android.experimental.api.Find;

import android.util.Log;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

public class CommodityFind extends Find {

	public static final String SYRINGES_IN = "syringes_in";
	public static final String SYRINGES_OUT = "syringes_out";
	public static final String IS_NEW = "is_new";

	@DatabaseField(columnName = SYRINGES_IN)
	protected int syringesIn;
	@DatabaseField(columnName = SYRINGES_OUT)
	protected int syringesOut;
	@DatabaseField(columnName = IS_NEW)
	protected boolean isNew;
	
	//This code adds the database fields
	public static final String cCommodity = "commodity";
	public static final String cPrice = "price";
	
	@DatabaseField(columnName = cCommodity)
	protected String commodity;
	@DatabaseField(columnName = cPrice)
	protected float price;
	

	public CommodityFind() {
		// Necessary by ormlite
	}
	
	/**
	 * Creates the table for this class.
	 * 
	 * @param connectionSource
	 */
	public static void createTable(ConnectionSource connectionSource) {
		Log.i(TAG, "Creating CommodityFind table");
		try {
			TableUtils.createTable(connectionSource, CommodityFind.class);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int getSyringesIn() {
		return syringesIn;
	}

	public void setSyringesIn(int syringesIn) {
		this.syringesIn = syringesIn;
	}

	public int getSyringesOut() {
		return syringesOut;
	}

	public void setSyringesOut(int syringesOut) {
		this.syringesOut = syringesOut;
	}

	public boolean isNew() {
		return isNew;
	}

	public void setNew(boolean isNew) {
		this.isNew = isNew;
	}
	
	//Commodity Tracker database setters and getters
	
	public String getCommodity() {
		return commodity;
	}

	public void setSyringesOut(String commodity) {
		this.commodity = commodity;
	}

	public float getPrice() {
		return price;
	}

	public void setNew(float price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(ORM_ID).append("=").append(id).append(",");
		sb.append(GUID).append("=").append(guid).append(",");
		sb.append(NAME).append("=").append(name).append(",");
		sb.append(LATITUDE).append("=").append(latitude).append(",");
		sb.append(LONGITUDE).append("=").append(longitude).append(",");
		if (time != null)
			sb.append(TIME).append("=").append(time.toString()).append(",");
		else
			sb.append(TIME).append("=").append("").append(",");
		if (modify_time != null)
			sb.append(MODIFY_TIME).append("=").append(modify_time.toString())
					.append(",");
		else
			sb.append(MODIFY_TIME).append("=").append("").append(",");
		sb.append(REVISION).append("=").append(revision).append(",");
		sb.append(IS_ADHOC).append("=").append(is_adhoc).append(",");
		sb.append(ACTION).append("=").append(action).append(",");
		sb.append(DELETED).append("=").append(deleted).append(",");
		sb.append(SYRINGES_IN).append("=").append(syringesIn).append(",");
		sb.append(SYRINGES_OUT).append("=").append(syringesOut).append(",");
		return sb.toString();
	}

}
