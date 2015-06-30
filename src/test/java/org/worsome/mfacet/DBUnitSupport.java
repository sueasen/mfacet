/**
 * Copyright (C) Toho System Science, Ltd.
 * All rights reserved
 */
package org.worsome.mfacet;

import java.io.InputStream;
import java.io.InputStreamReader;

import javax.sql.DataSource;

import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.SortedTable;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.springframework.beans.factory.BeanFactory;

/**
 * DBUnitUtils
 *
 * @author SUEHARAA1
 */
public class DBUnitSupport {

    /** beanFactory */
    private final BeanFactory beanFactory;

    /** class */
    private final Class<?> clazz;

    /**
     * コンストラクタ
     *
     * @param beanFactory beanFactory
     * @param clazz class
     * @exception Exception Exception
     */
    public DBUnitSupport(BeanFactory beanFactory, Class<?> clazz) throws Exception {
        this.beanFactory = beanFactory;
        this.clazz = clazz;
    }

    /**
     * DBコネクションを作成します
     *
     * @return DatabaseConnection
     * @throws Exception Exception
     */
    public IDatabaseConnection createDatabaseConnection() throws Exception {
        DataSource dataSource = beanFactory.getBean(DataSource.class);
        return new DatabaseConnection(dataSource.getConnection());
    }

    /**
     * xmlファイルよりデータセットを作成します
     *
     * @param fileName ファイル名
     * @return データセット
     * @throws Exception Exception
     */
    public IDataSet createFlatXmlDataSet(String fileName) throws Exception {
        try (InputStream stream = clazz.getResourceAsStream(fileName);) {
            return new FlatXmlDataSetBuilder().build(new InputStreamReader(stream));
        }
    }

    /**
     * データを登録します
     *
     * @param fileName ファイル名
     * @throws Exception Exception
     */
    public void cleanInsertData(String fileName) throws Exception {
        IDatabaseConnection connection = createDatabaseConnection();
        IDataSet dataSet = createFlatXmlDataSet(fileName);
        DatabaseOperation.CLEAN_INSERT.execute(connection, dataSet);
    }

    /**
     * データを削除します
     *
     * @param fileName ファイル名
     * @throws Exception Exception
     */
    public void deleteAllData(String fileName) throws Exception {
        IDatabaseConnection connection = createDatabaseConnection();
        IDataSet dataSet = createFlatXmlDataSet(fileName);
        DatabaseOperation.DELETE_ALL.execute(connection, dataSet);
    }

    /**
     * 実際のデータセットを生成します
     *
     * @return 実際のデータセット
     * @throws Exception Exception
     */
    public IDataSet getActualDataSet() throws Exception {
        IDatabaseConnection connection = createDatabaseConnection();
        return connection.createDataSet();
    }

    /**
     * 実際のテーブルを生成します
     *
     * @param tableName テーブル名
     * @return 実際のテーブル
     * @throws Exception Exception
     */
    public ITable getActualTable(String tableName) throws Exception {
        IDataSet dataSet = getActualDataSet();
        return dataSet.getTable(tableName);
    }

    /**
     * 実際のテーブルを生成します
     *
     * @param tableName テーブル名
     * @param sortColums ソートカラム
     * @return 実際のテーブル
     * @throws Exception Exception
     */
    public ITable getActualTable(String tableName, String... sortColums) throws Exception {
        ITable table = getActualTable(tableName);
        return getSortedTable(table, sortColums);
    }

    /**
     * 期待のデータセットを生成します
     *
     * @param fileName ファイル名
     * @return 期待のデータセット
     * @throws Exception Exception
     */
    public IDataSet getExpectedDataSet(String fileName) throws Exception {
        return createFlatXmlDataSet(fileName);
    }

    /**
     * 期待のテーブルを生成します
     *
     * @param fileName ファイル名
     * @param tableName テーブル名
     * @return 期待のテーブル
     * @throws Exception Exception
     */
    public ITable getExpectedTable(String fileName, String tableName) throws Exception {
        IDataSet dataSet = getExpectedDataSet(fileName);
        return dataSet.getTable(tableName);
    }

    /**
     * 期待のテーブルを生成します
     *
     * @param fileName ファイル名
     * @param tableName テーブル名
     * @param sortColums ソートカラム
     * @return 期待のテーブル
     * @throws Exception Exception
     */
    public ITable getExpectedTable(String fileName, String tableName, String... sortColums) throws Exception {
        ITable table = getExpectedTable(fileName, tableName);
        return getSortedTable(table, sortColums);
    }

    /**
     * ソートテーブルを生成します
     *
     * @param table テーブル
     * @param sortColums ソートカラム
     * @return ソートテーブル
     * @throws Exception Exception
     */
    public ITable getSortedTable(ITable table, String... sortColums) throws Exception {
        return new SortedTable(table, sortColums);
    }
}
