package com.softtanck.framework.net;


/**
 * ������Ӧ�ӿ�
 *
 * @param <T>
 */
public interface NetWorkRespListener<T> {
    /**
     * ������Ӧ�ɹ�
     *
     * @param response
     */
    public void onSuccessResponse(T response);

    /**
     * ������Ӧ�ɹ�
     *
     * @param response
     * @param type     ��Ӧ����
     */
    public void onSuccessResponse(T response, String type);

    /**
     * ������Ӧʧ��
     *
     * @param error
     */
    public void onErrorResponse(String error);
}
