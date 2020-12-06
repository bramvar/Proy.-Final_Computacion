package com.Brayan_Vargas.taller1.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the HAT_SERVER database table.
 * 
 */
@Entity
@Table(name="HAT_SERVER")
@NamedQuery(name="com.example.taller1.model.HatServer.findAll", query="SELECT h FROM HatServer h")
public class HatServer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="HAT_SERVER_SERVERID_GENERATOR", sequenceName="HAT_SERVER_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HAT_SERVER_SERVERID_GENERATOR")
	@Column(name="SERVER_ID")
	private long serverId;

	@Column(name="SERVER_BACKBASEPATH")
	private String serverBackbasepath;

	@Column(name="SERVER_BACKPROTOCOL")
	private String serverBackprotocol;

	@Column(name="SERVER_DNSBACKNAME")
	private String serverDnsbackname;

	@Column(name="SERVER_DNSBACKPORT")
	private String serverDnsbackport;

	@Column(name="SERVER_DNSFRONTNAME")
	private String serverDnsfrontname;

	@Column(name="SERVER_DNSFRONTPORT")
	private String serverDnsfrontport;

	@Column(name="SERVER_FRONTPROTOCOL")
	private String serverFrontprotocol;

	@Column(name="SERVER_ISPRODUCTION")
	private String serverIsproduction;

	@Column(name="SERVER_NAME")
	private String serverName;

	@Column(name="SERVER_VERSIONS")
	private String serverVersions;

	public HatServer() {
	}

	public long getServerId() {
		return this.serverId;
	}

	public void setServerId(long serverId) {
		this.serverId = serverId;
	}

	public String getServerBackbasepath() {
		return this.serverBackbasepath;
	}

	public void setServerBackbasepath(String serverBackbasepath) {
		this.serverBackbasepath = serverBackbasepath;
	}

	public String getServerBackprotocol() {
		return this.serverBackprotocol;
	}

	public void setServerBackprotocol(String serverBackprotocol) {
		this.serverBackprotocol = serverBackprotocol;
	}

	public String getServerDnsbackname() {
		return this.serverDnsbackname;
	}

	public void setServerDnsbackname(String serverDnsbackname) {
		this.serverDnsbackname = serverDnsbackname;
	}

	public String getServerDnsbackport() {
		return this.serverDnsbackport;
	}

	public void setServerDnsbackport(String serverDnsbackport) {
		this.serverDnsbackport = serverDnsbackport;
	}

	public String getServerDnsfrontname() {
		return this.serverDnsfrontname;
	}

	public void setServerDnsfrontname(String serverDnsfrontname) {
		this.serverDnsfrontname = serverDnsfrontname;
	}

	public String getServerDnsfrontport() {
		return this.serverDnsfrontport;
	}

	public void setServerDnsfrontport(String serverDnsfrontport) {
		this.serverDnsfrontport = serverDnsfrontport;
	}

	public String getServerFrontprotocol() {
		return this.serverFrontprotocol;
	}

	public void setServerFrontprotocol(String serverFrontprotocol) {
		this.serverFrontprotocol = serverFrontprotocol;
	}

	public String getServerIsproduction() {
		return this.serverIsproduction;
	}

	public void setServerIsproduction(String serverIsproduction) {
		this.serverIsproduction = serverIsproduction;
	}

	public String getServerName() {
		return this.serverName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	public String getServerVersions() {
		return this.serverVersions;
	}

	public void setServerVersions(String serverVersions) {
		this.serverVersions = serverVersions;
	}

}